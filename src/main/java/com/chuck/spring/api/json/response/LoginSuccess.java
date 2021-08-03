package com.chuck.spring.api.json.response;

import com.chuck.spring.api.json.Data;

public class LoginSuccess implements Data {
    String auth_token;

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }
}
