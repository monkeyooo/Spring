package com.chuck.spring.api.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitialUtil implements InitializingBean {
    private final Logger log = LogManager.getLogger(InitialUtil.class);
    @Override
    public void afterPropertiesSet() {

        log.info("Prepare static data......");
        log.info("Finish preparing static data......");
    }
}
