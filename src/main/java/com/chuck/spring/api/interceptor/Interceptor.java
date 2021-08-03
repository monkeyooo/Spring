package com.chuck.spring.api.interceptor;


import com.chuck.spring.api.utils.TokenUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interceptor extends BasicInterceptor {

    private final Logger logger = LogManager.getLogger(Interceptor.class);

    @Override
    boolean checkToken(String token) {
        return TokenUtil.isValidToken(token);
    }

    @Override
    String getErrorMessage() {
        return "Invalid Token";
    }

}
