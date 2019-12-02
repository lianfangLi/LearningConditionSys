package com.example.lianfang.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FinalGradeExtends extends FinalGrade {
    @ApiModelProperty(name = "className", example = "物联网")
    private String className;
    @ApiModelProperty(name = "17111", example = "高等数学")
    private String courName;

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
