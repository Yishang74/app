package com.mayikt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mayikt.entity.Class;
import com.mayikt.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<Class> {
    @Select("select class.id,class.class_name from class_teacher inner join class on class_teacher.class_id = class.id where class_teacher.teacher_id = #{id}")
    List<Class> getClassByTeacher(Integer id);

    @Select("select student.id,student.username,student.sex,student.phone,student.class_hours,student.school,student.major,student.grade," +
            "student.go_abroad_time,student.student_describe,student.parent_phone,student.failed_courses,application_objective,student.examination_time " +
            "from class_student inner join student on class_student.student_id = student.id " +
            "where class_student.class_id = #{id}")
    List<Student> getStudentByClass(Integer id);
}
