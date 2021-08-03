package com.chuck.spring.api.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


abstract class BasicInterceptor implements AsyncHandlerInterceptor {
    private final static Logger logger = LogManager.getLogger(Interceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getDispatcherType().equals(DispatcherType.REQUEST)) {
            return true;
        }
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String authHeader = requestWrapper.getHeader("Authorization");
        if (authHeader == null) {
            logger.info("Auth failed");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(getErrorMessage());
            return false;
        }
        if (!checkToken(authHeader)) {
            logger.info("Auth failed");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(getErrorMessage());
            return false;
        }
        logger.info("Auth Success");
        return true;
    }

    abstract boolean checkToken(String token);
    abstract String getErrorMessage();
}
