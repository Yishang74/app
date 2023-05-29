package com.mayikt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mayikt.entity.Course;
import com.mayikt.model.vo.AssginClassVo;

public interface CourseService extends IService<Course> {
    void doAssign(AssginClassVo vo);
}
