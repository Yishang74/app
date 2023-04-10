package com.mayikt.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2022-12-12
 */
public class Classcourserelationship implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer classCourseRelationship;

    private Integer courseId;

    private Integer classId;


    public Integer getClassCourseRelationship() {
        return classCourseRelationship;
    }

    public void setClassCourseRelationship(Integer classCourseRelationship) {
        this.classCourseRelationship = classCourseRelationship;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Classcourserelationship{" +
        "classCourseRelationship=" + classCourseRelationship +
        ", courseId=" + courseId +
        ", classId=" + classId +
        "}";
    }
}
