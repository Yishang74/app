package com.mayikt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.utils.MD5Utils;
import com.mayikt.entity.Student;
import com.mayikt.mapper.StudentMapper;
import com.mayikt.service.JwtLoginService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@CrossOrigin
@RestController
public class JwtLoginServiceImpl extends BaseApiService implements JwtLoginService {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public BaseResponse<String> loginJwt(String phoneNumber, String password) {
        // 验证参数
        if (StringUtils.isEmpty(phoneNumber)) {
            return setResultError("mobile 不能为空!");
        }
        if (StringUtils.isEmpty(password)) {
            return setResultError("passWord 不能为空!");
        }
        // md5加密
        QueryWrapper<Student> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("student_phone", phoneNumber);
        Student student = studentMapper.selectOne(sysUserQueryWrapper);
        if (student == null) {
            return setResultError("该手机号码或者密码错误!");
        }
        String dbPassword = student.getStudentPassword();
        String userPassword = MD5Utils.md5(password + student.getSalt());
        if (!dbPassword.equals(userPassword)) {
            return setResultError("password is wrong");
        }

        // 生成jwttoken
        String jwt = StudentJwtUtils.generateJsonWebToken(student);
        HashMap<String, String> data = new HashMap<>();
        data.put("token", jwt);
        data.put("user_name", MayiktJwtUtils.getPhone(jwt));
        return setResultSuccessData(data);
    }

    @Override
    public BaseResponse<String> jwtVerification(String jwt) {
        if (StringUtils.isEmpty(jwt)) {
            return setResultError("jwt is null");
        }
        Claims claims = MayiktJwtUtils.checkJWT(jwt);
        if (claims == null) {
            return setResultError("jwt error");
        }
        return setResultSuccess();
    }

}