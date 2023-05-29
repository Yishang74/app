package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserResDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;


@Api(tags = "用户基本信息接口")
public interface UserService {
    /**
     * 提供接口根据token查询用户信息
     */
    /**
     * 根据token获取用户信息
     *
     * @return
     */
    @GetMapping("/getByTokenUserInfo")
    @ApiOperation(value = "查询用户信息", notes = "根据token查询用户信息")
    @ApiImplicitParam(paramType = "query", name = "token", value = "用户token", required = true,dataTypeClass = String.class)
    BaseResponse<UserResDto> getByTokenUserInfo(String token);
}