package com.chuck.spring.api.controller.v1;

import com.chuck.spring.api.json.Response;
import com.chuck.spring.api.json.request.LoginRequest;
import com.chuck.spring.api.json.response.DeferredResponse;
import com.chuck.spring.api.json.response.doc.LoginDoc;
import com.chuck.spring.api.json.response.doc.LoginFailedDoc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ForkJoinPool;

@Api(tags = {"登入"} )
@RestController
@RequestMapping("v1")
public class SignController {
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = LoginDoc.class),
            @ApiResponse(code = 400, message = "Failed", response = LoginFailedDoc.class)
    })
    @ApiOperation(value = "Login", notes = "Login", httpMethod = "POST", produces =
            MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    @ResponseBody
    public DeferredResponse<ResponseEntity<Response>> login(@RequestBody LoginRequest requestBody) {
        DeferredResponse<ResponseEntity<Response>> response = new DeferredResponse<>();
        ForkJoinPool.commonPool().submit(() -> {
//            response.setResult(signService.login(requestBody));
        });
        return response;
    }
}
