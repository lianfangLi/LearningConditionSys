package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FinalGradeKey {
    @ApiModelProperty(name = "id",example = "17111205002")
    private String id;
    @ApiModelProperty(name = "classNo",example = "1")
    private String classNo;
    @ApiModelProperty(name = "courNo",example = "17111")
    private String courNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }

    public String getCourNo() {
        return courNo;
    }

    public void setCourNo(String courNo) {
        this.courNo = courNo == null ? null : courNo.trim();
    }
}