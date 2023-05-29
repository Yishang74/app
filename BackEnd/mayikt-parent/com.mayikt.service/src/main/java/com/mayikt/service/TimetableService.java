package com.mayikt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mayikt.entity.Timetable;
import com.mayikt.service.dto.ScheduleCourseResDto;
import com.mayikt.service.dto.SchedultResDto;

import java.util.List;

public interface TimetableService extends IService<Timetable> {
    List<SchedultResDto> getSchedule(Integer controlWeek,Integer teacherId);

    ScheduleCourseResDto getScheduleCourse(Integer teacherId, String name);

    List<SchedultResDto> getScheduleStudent(Integer controlWeek, Integer id);

    ScheduleCourseResDto getScheduleCourseStudent(Integer studentId, String name);
}
