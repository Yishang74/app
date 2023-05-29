package com.mayikt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mayikt.entity.ClassCourse;


public interface ClassCourseService extends IService<ClassCourse> {
    boolean updateByCourseClass(ClassCourse c);

    ClassCourse getExamTimeById(Integer courseId, Integer classId);
}
