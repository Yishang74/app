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
public class Studentadviserrelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "studentAdviserRelationship_id", type = IdType.AUTO)
    private Integer studentadviserrelationshipId;

    private Integer studentId;

    private Integer adviserId;


    public Integer getStudentadviserrelationshipId() {
        return studentadviserrelationshipId;
    }

    public void setStudentadviserrelationshipId(Integer studentadviserrelationshipId) {
        this.studentadviserrelationshipId = studentadviserrelationshipId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Integer adviserId) {
        this.adviserId = adviserId;
    }

    @Override
    public String toString() {
        return "Studentadviserrelationship{" +
        "studentadviserrelationshipId=" + studentadviserrelationshipId +
        ", studentId=" + studentId +
        ", adviserId=" + adviserId +
        "}";
    }
}
