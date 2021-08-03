package com.chuck.spring.api.json.response;

import com.chuck.spring.api.json.Data;

public class UserNotFound implements Data {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
