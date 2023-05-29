package com.mayikt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.*;
import com.mayikt.entity.Class;
import com.mayikt.mapper.ClassMapper;
import com.mayikt.model.vo.AssginClassVo;
import com.mayikt.model.vo.AssginStudentVo;
import com.mayikt.model.vo.AssginTeacherVo;
import com.mayikt.service.ClassCourseService;
import com.mayikt.service.ClassService;
import com.mayikt.service.ClassStudentService;
import com.mayikt.service.ClassTeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    private ClassMapper mapper;

    @Autowired
    private ClassTeacherService classTeacherService;
    @Autowired
    private ClassStudentService classStudentService;

    //    为班级分配老师
    @Override
    public void doAssignTeacher(AssginTeacherVo vo) {
        if ("r".equals(vo.getType())){
            LambdaQueryWrapper<ClassTeacher> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ClassTeacher::getClassId,vo.getClassId());
            classTeacherService.remove(wrapper);
        }
        List<Integer> teacherIds = vo.getTeacherIds();
        for(Integer teacherId:teacherIds){
            ClassTeacher classTeacher = new ClassTeacher();
            classTeacher.setTeacherId(teacherId);
            classTeacher.setClassId(vo.getClassId());
            classTeacherService.save(classTeacher);
        }
    }
    //    为班级分配学生
    @Override
    public void doAssignStudent(AssginStudentVo vo) {
        if ("r".equals(vo.getType())) {
            LambdaQueryWrapper<ClassStudent> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ClassStudent::getClassId, vo.getClassId());
            classStudentService.remove(wrapper);
        }
        List<Integer> studentIds = vo.getStudentIds();
        for (Integer studentId : studentIds){
            ClassStudent classStudent = new ClassStudent();
            classStudent.setStudentId(studentId);
            classStudent.setClassId(vo.getClassId());
            classStudentService.save(classStudent);
        }

    }

    @Override
    public List<Class> getClassByTeacher(Integer id) {
        return mapper.getClassByTeacher(id);
    }

    @Override
    public List<Student> getStudentByClass(Integer id) {
        return mapper.getStudentByClass(id);
    }
}
