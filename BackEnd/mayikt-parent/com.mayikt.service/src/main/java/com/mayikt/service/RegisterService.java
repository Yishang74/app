package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 余胜军
 * @ClassName RegisterService
 */
@Api(tags = "注册接口")
public interface RegisterService {
    /**
     * 用户注册
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册接口", notes = "根据手机号码、密码 实现注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "phoneNumber", value = "手机号码", required = true,dataTypeClass = String.class),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true,dataTypeClass = String.class)
    })
    BaseResponse<String> register(String phoneNumber, String password);
}