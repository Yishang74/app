package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.utils.MD5Utils;
import com.mayikt.common.core.utils.SaltUtils;
import com.mayikt.entity.Student;
import com.mayikt.mapper.StudentMapper;
import com.mayikt.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class RegisterServiceImpl extends BaseApiService implements RegisterService {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public BaseResponse<String> register(String phoneNumber, String password) {
        // 1.验证参数是否为空
        if (StringUtils.isEmpty(phoneNumber)) {
            return setResultError("phoneNumber is null");
        }
        if (StringUtils.isEmpty(password)) {
            return setResultError("password is null");
        }
        //2.判断手机号码是否存在如果存在则无法注册
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phoneNumber);
        Student studentDB = studentMapper.selectOne(queryWrapper);
        if (studentDB != null) {
            return setResultError("手机号码已经存在无法注册.");
        }
        //3.手机号码如果不存在  需要对密码加密 生成盐值
        String salt = SaltUtils.getSalt();
        Student sysUser = new Student(phoneNumber, MD5Utils.md5(password+salt), salt);
        int result = studentMapper.insert(sysUser);
        return setResultDb(result);
    }
}