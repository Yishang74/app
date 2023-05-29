package com.mayikt.model.vo;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class ClassVo {
    private Integer id;

    private String className;

    private Integer courseId;

    private Integer[] week_no;

    private Integer[] day_no;

    private Integer[] timeTableId;

    private Integer[] studentId;

    private Integer teacherId;

    private String location;
}
