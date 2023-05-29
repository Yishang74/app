package com.mayikt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mayikt.entity.Class;
import com.mayikt.entity.Student;
import com.mayikt.model.vo.AssginStudentVo;
import com.mayikt.model.vo.AssginTeacherVo;

import java.util.List;

public interface ClassService extends IService<Class> {
    void doAssignTeacher(AssginTeacherVo vo);

    void doAssignStudent(AssginStudentVo vo);

    List<Class> getClassByTeacher(Integer id);

    List<Student> getStudentByClass(Integer id);
}
