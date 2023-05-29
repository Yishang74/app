package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mayikt.common.core.api.BaseApiService;
import com.mayikt.common.core.api.BaseResponse;
import com.mayikt.common.core.utils.MayiktBeanUtils;
import com.mayikt.entity.Student;
import com.mayikt.mapper.StudentMapper;
import com.mayikt.service.StudentInfoService;
import com.mayikt.service.dto.StudentResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StudentInfoServiceImpl extends BaseApiService implements StudentInfoService {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public BaseResponse<String> getStudentInfo(String authorization) {
        System.out.println(authorization);
        String phoneNumber=StudentJwtUtils.getPhone(authorization);
        QueryWrapper<Student> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.eq("phone", phoneNumber);
        Student studentDB = studentMapper.selectOne(sysUserQueryWrapper);
        StudentResDto studentResDto = MayiktBeanUtils.doToDto(studentDB, StudentResDto.class);
        return setResultSuccessData(studentResDto);
    }
}
