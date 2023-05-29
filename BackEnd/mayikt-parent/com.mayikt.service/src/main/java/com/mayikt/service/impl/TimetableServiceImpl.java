package com.mayikt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mayikt.entity.Timetable;
import com.mayikt.mapper.TimetableMapper;
import com.mayikt.service.TimetableService;
import com.mayikt.service.dto.ScheduleCourseResDto;
import com.mayikt.service.dto.SchedultResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableServiceImpl extends ServiceImpl<TimetableMapper, Timetable> implements TimetableService {
    @Autowired
    private TimetableMapper mapper;
    @Override
    public List<SchedultResDto> getSchedule(Integer controlWeek,Integer teacherId) {
        return mapper.getSchedule(controlWeek,teacherId);
    }

    @Override
    public ScheduleCourseResDto getScheduleCourse(Integer teacherId, String name) {
        return mapper.getScheduleCourse(teacherId,name);
    }

    @Override
    public List<SchedultResDto> getScheduleStudent(Integer controlWeek, Integer id) {
        return mapper.getScheduleStudent(controlWeek,id);
    }

    @Override
    public ScheduleCourseResDto getScheduleCourseStudent(Integer studentId, String name) {
        return mapper.getScheduleCourseStudent(studentId,name);
    }
}
