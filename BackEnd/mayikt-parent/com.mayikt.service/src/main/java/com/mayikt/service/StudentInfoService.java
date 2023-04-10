package com.mayikt.service;

import com.mayikt.common.core.api.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public interface StudentInfoService {
    @GetMapping("/getStudentInfo")
    BaseResponse<String> getStudentInfo(@RequestHeader("Authorization") String authorization);
}
