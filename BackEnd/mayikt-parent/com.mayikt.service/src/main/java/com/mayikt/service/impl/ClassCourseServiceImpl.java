package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.mayikt.entity.ClassCourse;
import com.mayikt.mapper.ClassCourseMapper;
import com.mayikt.service.ClassCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassCourseServiceImpl extends ServiceImpl<ClassCourseMapper, ClassCourse> implements ClassCourseService {

    @Autowired
    private ClassCourseMapper mapper;

    @Override
    public boolean updateByCourseClass(ClassCourse c) {
        LambdaQueryWrapper<ClassCourse> wrapper = new LambdaQueryWrapper<>();
        return SqlHelper.retBool(mapper.update(c,wrapper));
    }

    @Override
    public ClassCourse getExamTimeById(Integer courseId, Integer classId) {
        LambdaQueryWrapper<ClassCourse> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ClassCourse::getCourseId,courseId);
        wrapper.eq(ClassCourse::getClassId,classId);
        return mapper.selectOne(wrapper);
    }
}
