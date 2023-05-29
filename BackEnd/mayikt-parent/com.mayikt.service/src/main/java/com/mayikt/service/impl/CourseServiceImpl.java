package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.ClassCourse;
import com.mayikt.entity.Course;
import com.mayikt.mapper.CourseMapper;
import com.mayikt.model.vo.AssginClassVo;
import com.mayikt.service.ClassCourseService;
import com.mayikt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private ClassCourseService service;

//    为课程分配班级
    @Override
    public void doAssign(AssginClassVo vo) {
        LambdaQueryWrapper<ClassCourse> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(ClassCourse::getCourseId,vo.getCourseId());
        service.remove(wrapper);

        ClassCourse classCourse = new ClassCourse();
        classCourse.setCourseId(vo.getCourseId());
        classCourse.setClassId(vo.getClassId());
        service.save(classCourse);
    }
}
