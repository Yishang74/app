package com.mayikt.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class AssginStudentVo {
    private Integer classId;

    private List<Integer> studentIds;

    private String type;
}
