package com.mayikt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mayikt.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> queryStudentByTeacher(Integer teacherId);

    int queryCourseHoursById(Integer userId);
}
