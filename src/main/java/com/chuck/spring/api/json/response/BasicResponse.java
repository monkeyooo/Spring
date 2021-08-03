package com.chuck.spring.api.json.response;

import com.chuck.spring.api.json.Data;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Basic response model")
public class BasicResponse implements Data {

    Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
