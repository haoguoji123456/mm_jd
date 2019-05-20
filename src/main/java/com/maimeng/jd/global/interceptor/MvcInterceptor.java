package com.maimeng.jd.global.interceptor;

import com.maimeng.jd.ApplicationContextProvider;
import com.maimeng.jd.core.user.user.UserService;
import com.maimeng.jd.global.exception.NoLoginException;
import com.maimeng.jd.tool.Constant;
import com.maimeng.jd.tool.JwtUtils;
import com.xiaoleilu.hutool.date.DateUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.xiaoleilu.hutool.date.DatePattern.NORM_DATETIME_MINUTE_PATTERN;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author wuweifeng wrote on 2017/10/27.
 */
public class MvcInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse response, Object handler) {

        MutableHttpServletRequest httpRequest = new MutableHttpServletRequest(httpServletRequest);
        //有些不需要校验
        if (ignoreUrl(httpRequest)) {
            return true;
        }

        String jwtToken = httpRequest.getHeader(AUTHORIZATION);
        if (jwtToken == null) {
            //没有Authorization
            throw new NoLoginException();
        }
        JwtUtils jwtUtils = ApplicationContextProvider.getBean(JwtUtils.class);
        Claims claims = jwtUtils.getClaimByToken(jwtToken);
        if (claims == null) {
            throw new NoLoginException();
        }
        logger.info("token的过期时间是：" + DateUtil.format(claims.getExpiration(), NORM_DATETIME_MINUTE_PATTERN));
        if (jwtUtils.isTokenExpired(claims.getExpiration())) {
            throw new NoLoginException();
        }

        //校验state
        String userIdAndSys = claims.getSubject();
        String[] array = userIdAndSys.split(",");
        Long userId = Long.valueOf(array[0]);
        //判断用户是否被删除禁用
        if (ApplicationContextProvider.getBean(UserService.class).isErrorUser(userId)) {
            throw new NoLoginException();
        }

        httpRequest.setAttribute(Constant.USERID, userId);
        return true;
    }


    private boolean ignoreUrl(MutableHttpServletRequest httpRequest) {
        //如 GET 
        String header = httpRequest.getMethod();
        String path = httpRequest.getRequestURI();

        Map<String, String> map = buildIgnorePath();
        for (String key : map.keySet()) {
            if (path.contains(key)) {
                String method = map.get(key);
                if (header.toUpperCase().equals(method) || "*".equals(method)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Map<String, String> buildIgnorePath() {
        Map<String, String> map = new HashMap<>();
        map.put("/goods", "GET");
        map.put("/sysUser/login", "POST");
        map.put("/user/login", "POST");
        map.put("/user/smsLogin", "POST");
        map.put("/error", "*");
        map.put("/user/regist", "POST");
        map.put("/alipay", "*");

        return map;
    }

}
