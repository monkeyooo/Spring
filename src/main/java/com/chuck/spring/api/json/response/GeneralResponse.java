package com.chuck.spring.api.json.response;


import com.chuck.spring.api.json.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "General response model")
public class GeneralResponse<T> implements Response {
    private int result_code;
    @ApiModelProperty(value = "API response data", required = true)
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }

    @Override
    public int getResult_Code() {
        return result_code;
    }
}
