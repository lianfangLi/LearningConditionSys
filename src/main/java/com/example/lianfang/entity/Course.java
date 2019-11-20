package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "课程类",description = "该类中courNo必填 其他属性可选填，学期，学分属性为数值型 其他都为字符型")
public class Course {
    @ApiModelProperty(name = "courNo", required = true, example = "1")
    private String courNo;
    @ApiModelProperty(name = "courName", required = false, example = "高等数学")
    private String courName;
    @ApiModelProperty(name = "credit", required = false, example = "4")
    private Float credit;
    @ApiModelProperty(name = "period", value ="学期号", required = false, example = "1")
    private Integer period;

    public String getCourNo() {
        return courNo;
    }

    public void setCourNo(String courNo) {
        this.courNo = courNo == null ? null : courNo.trim();
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName == null ? null : courName.trim();
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}