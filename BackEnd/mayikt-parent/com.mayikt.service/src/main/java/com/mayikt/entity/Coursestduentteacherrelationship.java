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
 * @since 2022-12-11
 */
public class Coursestduentteacherrelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "courseStduentTeacherRelationship_id", type = IdType.AUTO)
    private Integer coursestduentteacherrelationshipId;

    private Integer courseId;

    private Integer studentId;

    private Integer teacherId;


    public Integer getCoursestduentteacherrelationshipId() {
        return coursestduentteacherrelationshipId;
    }

    public void setCoursestduentteacherrelationshipId(Integer coursestduentteacherrelationshipId) {
        this.coursestduentteacherrelationshipId = coursestduentteacherrelationshipId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Coursestduentteacherrelationship{" +
        "coursestduentteacherrelationshipId=" + coursestduentteacherrelationshipId +
        ", courseId=" + courseId +
        ", studentId=" + studentId +
        ", teacherId=" + teacherId +
        "}";
    }
}
