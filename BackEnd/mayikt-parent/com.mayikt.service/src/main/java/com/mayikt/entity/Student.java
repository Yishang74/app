package com.mayikt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2022-12-12
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    private String studentName;

    private String studentSex;

    private String studentPhone;

    private String studentPassword;

    private String salt;

    private Integer studentClasshours;

    private String studentSchool;

    private String studentMajor;

    private String studentGrade;

    private LocalDate studentGoabroadtime;

    private String studentDescribe;

    private Integer studentParentphone;

    private String studentFailedcourses;

    private String studentApplicationobjective;

    private LocalDate studentExaminationtime;

    public Student(String studentPhone, String studentPassword, String salt) {
        this.studentPhone = studentPhone;
        this.studentPassword = studentPassword;
        this.salt = salt;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStudentClasshours() {
        return studentClasshours;
    }

    public void setStudentClasshours(Integer studentClasshours) {
        this.studentClasshours = studentClasshours;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public LocalDate getStudentGoabroadtime() {
        return studentGoabroadtime;
    }

    public void setStudentGoabroadtime(LocalDate studentGoabroadtime) {
        this.studentGoabroadtime = studentGoabroadtime;
    }

    public String getStudentDescribe() {
        return studentDescribe;
    }

    public void setStudentDescribe(String studentDescribe) {
        this.studentDescribe = studentDescribe;
    }

    public Integer getStudentParentphone() {
        return studentParentphone;
    }

    public void setStudentParentphone(Integer studentParentphone) {
        this.studentParentphone = studentParentphone;
    }

    public String getStudentFailedcourses() {
        return studentFailedcourses;
    }

    public void setStudentFailedcourses(String studentFailedcourses) {
        this.studentFailedcourses = studentFailedcourses;
    }

    public String getStudentApplicationobjective() {
        return studentApplicationobjective;
    }

    public void setStudentApplicationobjective(String studentApplicationobjective) {
        this.studentApplicationobjective = studentApplicationobjective;
    }

    public LocalDate getStudentExaminationtime() {
        return studentExaminationtime;
    }

    public void setStudentExaminationtime(LocalDate studentExaminationtime) {
        this.studentExaminationtime = studentExaminationtime;
    }

    @Override
    public String toString() {
        return "Student{" +
        "studentId=" + studentId +
        ", studentName=" + studentName +
        ", studentSex=" + studentSex +
        ", studentPhone=" + studentPhone +
        ", studentPassword=" + studentPassword +
        ", salt=" + salt +
        ", studentClasshours=" + studentClasshours +
        ", studentSchool=" + studentSchool +
        ", studentMajor=" + studentMajor +
        ", studentGrade=" + studentGrade +
        ", studentGoabroadtime=" + studentGoabroadtime +
        ", studentDescribe=" + studentDescribe +
        ", studentParentphone=" + studentParentphone +
        ", studentFailedcourses=" + studentFailedcourses +
        ", studentApplicationobjective=" + studentApplicationobjective +
        ", studentExaminationtime=" + studentExaminationtime +
        "}";
    }
}
