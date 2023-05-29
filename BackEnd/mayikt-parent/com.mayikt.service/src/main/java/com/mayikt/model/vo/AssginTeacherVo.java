package com.mayikt.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class AssginTeacherVo {
    private Integer classId;

    private List<Integer> teacherIds;

    private String type;
}
