package com.mayikt.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2022-12-12
 */
@Data
@TableName("course_coursetime")
public class CourseCourseTime implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer courseId;

    private Integer coursetimeId;

}
