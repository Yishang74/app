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
public class UserResDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("用户id")

    private Integer id;


    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("登陆名称")
    private String userName;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String phoneNumber;

    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;

    @ApiModelProperty("头像地址")
    private String avatar;


    @ApiModelProperty("生日")
    private LocalDate birthday;

    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;


    @ApiModelProperty("最后登录IP")
    private String loginIp;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime loginDate;

    public String getPhoneNumber() {
        return DesensitizationUtil.mobileEncrypt(phoneNumber);
    }
}