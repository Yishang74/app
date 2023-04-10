package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2022-12-12
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    private String teacherName;

    private String teacherPhone;

    private String teacherPassword;

    private String salt;

    private Integer teacherAge;

    private String teacherMajor;

    private String teacherQualification;

    private String teacherUniversity;

    private String teacherTitle;

    private Integer teacherTeachingexperience;


    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherMajor() {
        return teacherMajor;
    }

    public void setTeacherMajor(String teacherMajor) {
        this.teacherMajor = teacherMajor;
    }

    public String getTeacherQualification() {
        return teacherQualification;
    }

    public void setTeacherQualification(String teacherQualification) {
        this.teacherQualification = teacherQualification;
    }

    public String getTeacherUniversity() {
        return teacherUniversity;
    }

    public void setTeacherUniversity(String teacherUniversity) {
        this.teacherUniversity = teacherUniversity;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public Integer getTeacherTeachingexperience() {
        return teacherTeachingexperience;
    }

    public void setTeacherTeachingexperience(Integer teacherTeachingexperience) {
        this.teacherTeachingexperience = teacherTeachingexperience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "teacherId=" + teacherId +
        ", teacherName=" + teacherName +
        ", teacherPhone=" + teacherPhone +
        ", teacherPassword=" + teacherPassword +
        ", salt=" + salt +
        ", teacherAge=" + teacherAge +
        ", teacherMajor=" + teacherMajor +
        ", teacherQualification=" + teacherQualification +
        ", teacherUniversity=" + teacherUniversity +
        ", teacherTitle=" + teacherTitle +
        ", teacherTeachingexperience=" + teacherTeachingexperience +
        "}";
    }
}
