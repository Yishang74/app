package com.mayikt.service.dto;

import lombok.Data;

@Data
public class SchedultResDto {
    private Integer courseId;
    private Integer weekdayId;
    private Integer timetableId;
    private String timetableName;
    private String courseName;
    private Integer weekNo;
    private Integer dayNo;
}
