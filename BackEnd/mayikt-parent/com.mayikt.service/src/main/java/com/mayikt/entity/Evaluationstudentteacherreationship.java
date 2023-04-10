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
public class Evaluationstudentteacherreationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "evaluationStudentTeacherReationship_id", type = IdType.AUTO)
    private Integer evaluationstudentteacherreationshipId;

    private Integer evaluationId;

    private Integer studentId;

    private Integer teacherId;


    public Integer getEvaluationstudentteacherreationshipId() {
        return evaluationstudentteacherreationshipId;
    }

    public void setEvaluationstudentteacherreationshipId(Integer evaluationstudentteacherreationshipId) {
        this.evaluationstudentteacherreationshipId = evaluationstudentteacherreationshipId;
    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
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
        return "Evaluationstudentteacherreationship{" +
        "evaluationstudentteacherreationshipId=" + evaluationstudentteacherreationshipId +
        ", evaluationId=" + evaluationId +
        ", studentId=" + studentId +
        ", teacherId=" + teacherId +
        "}";
    }
}
