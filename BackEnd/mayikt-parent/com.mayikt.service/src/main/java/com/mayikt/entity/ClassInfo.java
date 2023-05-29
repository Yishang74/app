package com.mayikt.entity;

import lombok.Data;

import java.util.List;


@Data
public class ClassInfo {
    private String className;
    private List<Student> info;
}
