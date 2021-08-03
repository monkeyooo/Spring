package com.chuck.spring.api.json.response;

import org.springframework.web.context.request.async.DeferredResult;

public class DeferredResponse<T> extends DeferredResult<T> {

    public DeferredResponse() {

        super(15000L, new Timeout());
//        super.onTimeout(() -> {
//
//            super.setErrorResult(timeout);
//        });
    }
}
