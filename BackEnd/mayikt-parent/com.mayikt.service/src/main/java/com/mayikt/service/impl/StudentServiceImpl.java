package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.ClassTeacher;
import com.mayikt.entity.Student;
import com.mayikt.mapper.StudentMapper;
import com.mayikt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> queryStudentByTeacher(Integer teacherId) {
        return mapper.selectListByTeacher(teacherId);
    }

    @Override
    public int queryCourseHoursById(Integer userId) {
        return mapper.queryCourseHoursById(userId);
    }
}
