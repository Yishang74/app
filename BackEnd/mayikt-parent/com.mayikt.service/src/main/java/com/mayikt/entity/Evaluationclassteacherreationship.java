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
public class Evaluationclassteacherreationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "evaluationClassTeacherReationship_id", type = IdType.AUTO)
    private Integer evaluationclassteacherreationshipId;

    private Integer evaluationId;

    private Integer classId;

    private Integer teacherId;


    public Integer getEvaluationclassteacherreationshipId() {
        return evaluationclassteacherreationshipId;
    }

    public void setEvaluationclassteacherreationshipId(Integer evaluationclassteacherreationshipId) {
        this.evaluationclassteacherreationshipId = evaluationclassteacherreationshipId;
    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Evaluationclassteacherreationship{" +
        "evaluationclassteacherreationshipId=" + evaluationclassteacherreationshipId +
        ", evaluationId=" + evaluationId +
        ", classId=" + classId +
        ", teacherId=" + teacherId +
        "}";
    }
}
