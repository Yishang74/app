package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.ClassTeacher;
import com.mayikt.mapper.ClassTeacherMapper;
import com.mayikt.service.ClassTeacherService;
import org.springframework.stereotype.Service;

@Service
public class ClassTeacherServiceImpl extends ServiceImpl<ClassTeacherMapper, ClassTeacher> implements ClassTeacherService {
}
