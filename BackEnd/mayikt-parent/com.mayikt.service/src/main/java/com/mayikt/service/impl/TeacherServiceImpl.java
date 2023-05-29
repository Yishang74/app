package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.Teacher;
import com.mayikt.mapper.TeacherMapper;
import com.mayikt.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
