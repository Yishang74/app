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
public class Coursestudentteacherrelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "courseStudentTeacherRelationship_id", type = IdType.AUTO)
    private Integer coursestudentteacherrelationshipId;

    private Integer courseId;

    private Integer studentId;

    private Integer teacherId;


    public Integer getCoursestudentteacherrelationshipId() {
        return coursestudentteacherrelationshipId;
    }

    public void setCoursestudentteacherrelationshipId(Integer coursestudentteacherrelationshipId) {
        this.coursestudentteacherrelationshipId = coursestudentteacherrelationshipId;
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
        return "Coursestudentteacherrelationship{" +
        "coursestudentteacherrelationshipId=" + coursestudentteacherrelationshipId +
        ", courseId=" + courseId +
        ", studentId=" + studentId +
        ", teacherId=" + teacherId +
        "}";
    }
}
