package com.mayikt.service.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mayikt.common.core.utils.DesensitizationUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@ApiModel(value = "返回用户信息", description = "返回用户信息")
public class StudentResDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)



    private String username;

    private String sex;

    private String phone;

    private Integer classHours;

    private String school;

    private String major;

    private String grade;

    private LocalDate goAbroadTime;

    private String studentDescribe;

    private Integer parentPhone;

    private String failedCourses;

    private String applicationObjective;

    private LocalDate examinationTime;

}