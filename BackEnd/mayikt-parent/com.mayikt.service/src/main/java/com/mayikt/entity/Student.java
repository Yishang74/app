package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("sex")
    private String sex;

    @TableField("phone")
    private String phone;

    @TableField("password")
    private String password;

    @TableField("salt")
    private String salt;

    @TableField("class_hours")
    private Integer classHours;

    @TableField("school")
    private String school;

    @TableField("major")
    private String major;

    @TableField("grade")
    private String grade;

    @TableField("go_abroad_time")
    private Date goAbroadTime;

    @TableField("student_describe")
    private String studentDescribe;

    @TableField("parent_phone")
    private String parentPhone;

    @TableField("failed_courses")
    private String failedCourses;

    @TableField("application_objective")
    private String applicationObjective;

    @TableField("examination_time")
    private Date examinationTime;

    public Student(String phoneNumber, String md5, String salt) {
    }
}
