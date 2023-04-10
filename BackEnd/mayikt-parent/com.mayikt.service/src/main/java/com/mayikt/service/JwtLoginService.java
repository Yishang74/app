package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.service.dto.UserResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface JwtLoginService {
    /**
     * jwt登录的方式
     *
     * @return
     */
    @PostMapping("loginJwt")
    BaseResponse<String> loginJwt(String phoneNumber, String password);

    /**
     * jwt 验证
     *
     * @return
     */
    @GetMapping("jwtVerification")
    BaseResponse<String> jwtVerification(@RequestParam("jwt") String jwt);
}