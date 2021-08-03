package com.chuck.spring.api.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final Logger log = LogManager.getLogger(ApiExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity handlerAllException (Exception e) {
        log.info(ExceptionUtils.getStackTrace(e));
        return new ResponseEntity("Internal Server Error : "+ ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
