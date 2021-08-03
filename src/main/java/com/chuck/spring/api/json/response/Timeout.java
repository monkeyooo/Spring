package com.chuck.spring.api.json.response;

import com.chuck.spring.api.json.Response;
import org.springframework.http.HttpStatus;

public class Timeout implements Response {
    String message;
    int result_code;

    public Timeout() {
        message = "Request Timeout";
        result_code = HttpStatus.REQUEST_TIMEOUT.value();
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int getResult_Code() {
        return result_code;
    }
}
