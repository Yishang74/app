package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("class_teacher")
public class ClassTeacher implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer classId;

    private Integer teacherId;
}
