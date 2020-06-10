package com.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Interceptor extends BasicInterceptor {

    private final Logger logger = LogManager.getLogger(Interceptor.class);

    @Override
    boolean checkToken(String token) {
        return true;
    }

    @Override
    String getErrorMessage() {
        return "suck";
    }
}
