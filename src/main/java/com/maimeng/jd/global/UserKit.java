package com.maimeng.jd.global;

import com.maimeng.jd.core.user.user.PtUserManager;
import com.maimeng.jd.tool.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wuweifeng wrote on 2018/11/6.
 */
@Component
public class UserKit {
    @Resource
    private PtUserManager ptUserManager;

    public Long getCurrentUserId() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (request.getAttribute(Constant.USERID) == null) {
            return null;
        }
        return Long.valueOf(request.getAttribute(Constant.USERID).toString());
    }


    public static void main(String[] args) {
        String url = "http://jnrise.tianyalei.com/score";
        url = url.replace("http://", "").replace("www.", "");
        url = url.substring(0, url.indexOf("/"));
        System.out.println(url);
    }

    /**
     * 获取用户的来源，如android，ios，web
     */
    public String getUserAgent() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request.getHeader(Constant.USER_AGENT);
    }

}
