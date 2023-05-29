package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2022-12-12
 */
@Data
@TableName("class_course")
public class ClassCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer courseId;

    private Integer classId;

    private Date examTime;

    private String location;

}
