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
public class Classstudentteacherrelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "classStudentTeacherRelationship_id", type = IdType.AUTO)
    private Integer classstudentteacherrelationshipId;

    private Integer classId;

    private Integer studentId;

    private Integer teacherId;


    public Integer getClassstudentteacherrelationshipId() {
        return classstudentteacherrelationshipId;
    }

    public void setClassstudentteacherrelationshipId(Integer classstudentteacherrelationshipId) {
        this.classstudentteacherrelationshipId = classstudentteacherrelationshipId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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
        return "Classstudentteacherrelationship{" +
        "classstudentteacherrelationshipId=" + classstudentteacherrelationshipId +
        ", classId=" + classId +
        ", studentId=" + studentId +
        ", teacherId=" + teacherId +
        "}";
    }
}
