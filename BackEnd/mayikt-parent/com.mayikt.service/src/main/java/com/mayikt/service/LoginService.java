package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Api(tags = "登录接口")
public interface LoginService {
    /**
     * 用户登录接口
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    @GetMapping("/login")
    @ApiOperation(value = "登录接口", notes = "根据手机号码、密码 实现登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "phoneNumber", value = "手机号码", required = true,dataTypeClass = String.class),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true,dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "登录成功"),
            @ApiResponse(code = 500, message = "登录失败")})
    BaseResponse<String> login(String phoneNumber, String password);
}