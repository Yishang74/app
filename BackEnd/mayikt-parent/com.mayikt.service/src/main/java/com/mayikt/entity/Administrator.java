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
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "administrators_id", type = IdType.AUTO)
    private Integer administratorsId;

    private String administratorsName;

    private String administratorsPhone;

    private String administratorsPassword;

    private String salt;


    public Integer getAdministratorsId() {
        return administratorsId;
    }

    public void setAdministratorsId(Integer administratorsId) {
        this.administratorsId = administratorsId;
    }

    public String getAdministratorsName() {
        return administratorsName;
    }

    public void setAdministratorsName(String administratorsName) {
        this.administratorsName = administratorsName;
    }

    public String getAdministratorsPhone() {
        return administratorsPhone;
    }

    public void setAdministratorsPhone(String administratorsPhone) {
        this.administratorsPhone = administratorsPhone;
    }

    public String getAdministratorsPassword() {
        return administratorsPassword;
    }

    public void setAdministratorsPassword(String administratorsPassword) {
        this.administratorsPassword = administratorsPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Administrator{" +
        "administratorsId=" + administratorsId +
        ", administratorsName=" + administratorsName +
        ", administratorsPhone=" + administratorsPhone +
        ", administratorsPassword=" + administratorsPassword +
        ", salt=" + salt +
        "}";
    }
}
