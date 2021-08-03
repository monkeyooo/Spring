package com.chuck.spring.api.json.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "General request model")
public class PostRequest<T> {

    @ApiModelProperty(value = "API request data", required = true)
    @JsonProperty("query-param")
    T query_param;

    public T getQuery_param() {
        return query_param;
    }

    public void setQuery_param(T query_param) {
        this.query_param = query_param;
    }

}
