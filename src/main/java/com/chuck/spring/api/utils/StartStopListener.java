package com.chuck.spring.api.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Properties;
import java.util.Set;

@WebListener
public class StartStopListener implements ServletContextListener {

	private static final Logger logger = LogManager.getLogger(StartStopListener.class);

	private static final String RMC_QPORT_DB_HOST = System.getProperty("RMC_QPORT_DB_HOST");
    
    public void contextDestroyed(ServletContextEvent arg0) {

        
    }

    public void contextInitialized(ServletContextEvent arg0) {

        //init jobs
        logger.info("RMC_QPORT_DB_HOST ==> "+RMC_QPORT_DB_HOST);

        Properties properties = System.getProperties();
        Set<Object>  sysPropertiesKeys = properties.keySet();
        for (Object key : sysPropertiesKeys) {
        	logger.info(key + " = " + properties.getProperty((String)key));
        }
    }
        
    


}
