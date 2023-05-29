package com.mayikt.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mayikt.entity.Timetable;
import com.mayikt.service.dto.ScheduleCourseResDto;
import com.mayikt.service.dto.SchedultResDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TimetableMapper extends BaseMapper<Timetable> {
    @Select("select `index`,name from timetable")
    @Override
    List<Timetable> selectList(Wrapper<Timetable> queryWrapper);

    @Select("select d.id course_id,d.name course_name,b.id weekday_id,b.week_no,b.day_no,c.index timetable_id,c.name timetable_name " +
            "from schedule a inner join weekday b on a.weekday_id = b.id " +
            "inner join timetable c on c.index = a.timetable_id " +
            "inner join course d on d.id = a.course_id " +
            "inner join class_course e on e.course_id = d.id " +
            "inner join class_teacher f on e.class_id = f.class_id " +
            "where b.week_no = #{controlWeek} and f.teacher_id = #{teacherId}")
    List<SchedultResDto> getSchedule(Integer controlWeek,Integer teacherId);

    @Select("select course.`name` course_name,teacher.username, class_course.location " +
            "from course " +
            "inner join class_course on class_course.course_id = course.id " +
            "inner join class_teacher on class_teacher.class_id = class_course.class_id " +
            "inner JOIN teacher on teacher.id = class_teacher.teacher_id " +
            "where course.name = #{name} and teacher.id = #{teacherId}")
    ScheduleCourseResDto getScheduleCourse(Integer teacherId, String name);

    @Select("select d.id course_id,d.name course_name,b.id weekday_id,b.week_no,b.day_no,c.index timetable_id,c.name timetable_name " +
            "from schedule a inner join weekday b on a.weekday_id = b.id " +
            "inner join timetable c on c.index = a.timetable_id " +
            "inner join course d on d.id = a.course_id " +
            "inner join class_course e on e.course_id = d.id " +
            "inner join class_student f on e.class_id = f.class_id " +
            "where b.week_no = #{controlWeek} and f.student_id = #{id}")
    List<SchedultResDto> getScheduleStudent(Integer controlWeek, Integer id);

    @Select("select course.`name` course_name,student.username, class_course.location " +
            "from course " +
            "inner join class_course on class_course.course_id = course.id " +
            "inner join class_student on class_student.class_id = class_course.class_id " +
            "inner JOIN student on student.id = class_student.student_id " +
            "where course.name = #{name} and student.id = #{studentId} limit 1")
    ScheduleCourseResDto getScheduleCourseStudent(Integer studentId, String name);
}
