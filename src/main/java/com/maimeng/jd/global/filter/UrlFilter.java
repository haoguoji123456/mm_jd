package com.maimeng.jd.global.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 加统一的前缀
 * @author wuweifeng wrote on 2018/11/1.
 */
@Component
public class UrlFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();
        if (path.contains("/mmJd")) {
            path = path.replace("/mmJd", "");
            httpRequest.getRequestDispatcher(path).forward(httpRequest, response);
        }

    }
}