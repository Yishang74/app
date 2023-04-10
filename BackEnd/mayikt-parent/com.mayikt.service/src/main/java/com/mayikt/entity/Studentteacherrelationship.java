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
public class Studentteacherrelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "studentTeacherRelationship_id", type = IdType.AUTO)
    private Integer studentteacherrelationshipId;

    private Integer studentId;

    private Integer teacherId;


    public Integer getStudentteacherrelationshipId() {
        return studentteacherrelationshipId;
    }

    public void setStudentteacherrelationshipId(Integer studentteacherrelationshipId) {
        this.studentteacherrelationshipId = studentteacherrelationshipId;
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
        return "Studentteacherrelationship{" +
        "studentteacherrelationshipId=" + studentteacherrelationshipId +
        ", studentId=" + studentId +
        ", teacherId=" + teacherId +
        "}";
    }
}
