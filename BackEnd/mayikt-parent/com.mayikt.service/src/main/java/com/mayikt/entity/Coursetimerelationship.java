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
public class Coursetimerelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "courseTimeRelationship", type = IdType.AUTO)
    private Integer courseTimeRelationship;

    private Integer courseId;

    private Integer coursetimeId;


    public Integer getCourseTimeRelationship() {
        return courseTimeRelationship;
    }

    public void setCourseTimeRelationship(Integer courseTimeRelationship) {
        this.courseTimeRelationship = courseTimeRelationship;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCoursetimeId() {
        return coursetimeId;
    }

    public void setCoursetimeId(Integer coursetimeId) {
        this.coursetimeId = coursetimeId;
    }

    @Override
    public String toString() {
        return "Coursetimerelationship{" +
        "courseTimeRelationship=" + courseTimeRelationship +
        ", courseId=" + courseId +
        ", coursetimeId=" + coursetimeId +
        "}";
    }
}
