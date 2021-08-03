package com.chuck.spring.api.json.response;

import com.chuck.spring.api.json.Data;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class ServerInternalError implements Data {
    String message;
    public ServerInternalError(Exception e) {
        setMessage(ExceptionUtils.getStackTrace(e));
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }
}
