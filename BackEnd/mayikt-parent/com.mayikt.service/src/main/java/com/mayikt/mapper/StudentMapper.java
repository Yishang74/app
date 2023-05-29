package com.mayikt.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mayikt.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bruce
 * @since 2022-12-05
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select id,username,sex,phone,classHours,school,major,grade,goAbroadTime,studentDescribe,parentPhone,failedCourses,applicationObjective,examinationTime " +
            "from class_teacher as A " +
            "inner join class_student as B on A.class_id = B.class_id " +
            "inner join student as C on B.student_id = C.id " +
            "where A.teacher_id = #{teacherId}")
    List<Student> selectListByTeacher(Integer teacherId);

    @Select("select class_hours from student where user_id = #{userId}")
    int queryCourseHoursById(Integer userId);
}
