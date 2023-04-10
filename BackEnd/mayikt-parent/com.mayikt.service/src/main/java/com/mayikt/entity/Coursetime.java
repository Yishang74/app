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
public class Coursetime implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "courseTime_id", type = IdType.AUTO)
    private Integer coursetimeId;

    private Integer courseTime;

    private String courseVenue;


    public Integer getCoursetimeId() {
        return coursetimeId;
    }

    public void setCoursetimeId(Integer coursetimeId) {
        this.coursetimeId = coursetimeId;
    }

    public Integer getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Integer courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseVenue() {
        return courseVenue;
    }

    public void setCourseVenue(String courseVenue) {
        this.courseVenue = courseVenue;
    }

    @Override
    public String toString() {
        return "Coursetime{" +
        "coursetimeId=" + coursetimeId +
        ", courseTime=" + courseTime +
        ", courseVenue=" + courseVenue +
        "}";
    }
}
