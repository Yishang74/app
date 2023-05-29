package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.ClassStudent;
import com.mayikt.mapper.ClassStudentMapper;
import com.mayikt.service.ClassStudentService;
import org.springframework.stereotype.Service;

@Service
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentMapper, ClassStudent> implements ClassStudentService {
}
