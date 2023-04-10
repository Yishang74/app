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
public class Adviser implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "adviser_id", type = IdType.AUTO)
    private Integer adviserId;

    private String adviserName;

    private String adviserPhone;

    private String adviserPassword;

    private String salt;

    private Integer adviserAge;

    private String adviserMajor;

    private String adviserQualification;

    private String adviserUniversity;

    private String adviserTitle;

    private Integer adviserAdviseexperience;


    public Integer getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Integer adviserId) {
        this.adviserId = adviserId;
    }

    public String getAdviserName() {
        return adviserName;
    }

    public void setAdviserName(String adviserName) {
        this.adviserName = adviserName;
    }

    public String getAdviserPhone() {
        return adviserPhone;
    }

    public void setAdviserPhone(String adviserPhone) {
        this.adviserPhone = adviserPhone;
    }

    public String getAdviserPassword() {
        return adviserPassword;
    }

    public void setAdviserPassword(String adviserPassword) {
        this.adviserPassword = adviserPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getAdviserAge() {
        return adviserAge;
    }

    public void setAdviserAge(Integer adviserAge) {
        this.adviserAge = adviserAge;
    }

    public String getAdviserMajor() {
        return adviserMajor;
    }

    public void setAdviserMajor(String adviserMajor) {
        this.adviserMajor = adviserMajor;
    }

    public String getAdviserQualification() {
        return adviserQualification;
    }

    public void setAdviserQualification(String adviserQualification) {
        this.adviserQualification = adviserQualification;
    }

    public String getAdviserUniversity() {
        return adviserUniversity;
    }

    public void setAdviserUniversity(String adviserUniversity) {
        this.adviserUniversity = adviserUniversity;
    }

    public String getAdviserTitle() {
        return adviserTitle;
    }

    public void setAdviserTitle(String adviserTitle) {
        this.adviserTitle = adviserTitle;
    }

    public Integer getAdviserAdviseexperience() {
        return adviserAdviseexperience;
    }

    public void setAdviserAdviseexperience(Integer adviserAdviseexperience) {
        this.adviserAdviseexperience = adviserAdviseexperience;
    }

    @Override
    public String toString() {
        return "Adviser{" +
        "adviserId=" + adviserId +
        ", adviserName=" + adviserName +
        ", adviserPhone=" + adviserPhone +
        ", adviserPassword=" + adviserPassword +
        ", salt=" + salt +
        ", adviserAge=" + adviserAge +
        ", adviserMajor=" + adviserMajor +
        ", adviserQualification=" + adviserQualification +
        ", adviserUniversity=" + adviserUniversity +
        ", adviserTitle=" + adviserTitle +
        ", adviserAdviseexperience=" + adviserAdviseexperience +
        "}";
    }
}
