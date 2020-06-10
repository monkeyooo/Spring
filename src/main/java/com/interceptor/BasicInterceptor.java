package com.interceptor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


abstract class BasicInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String jsonBody = requestWrapper.getBody();
        Map<String, Object> jsonMap;
        if (StringUtils.isNotBlank(jsonBody)) {
            try {
                jsonMap = new ObjectMapper().readValue(jsonBody, HashMap.class);
            } catch (JsonParseException jsonParseException){
                response.getWriter().write("JSON 格式錯誤");
                return false;
            }
        } else {
            response.getWriter().write(getErrorMessage());
            return false;
        }

        if (!jsonMap.containsKey("token")) {
            response.getWriter().write(getErrorMessage());
            return false;
        }

        String token = (String) jsonMap.get("token");
        if (checkToken(token)) return true;
        else {
            response.getWriter().write(getErrorMessage());
            return false;
        }
    }

    abstract boolean checkToken(String token);
    abstract String getErrorMessage();
}
