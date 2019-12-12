package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class HomeworkKey {
    @ApiModelProperty(name ="id",example = "17111205002" )
    private String id;
    @ApiModelProperty(name ="whichSubject",example = "17111" )
    private String whichSubject;
    @ApiModelProperty(name ="whichTime",example = "1" )
    private Integer whichTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWhichSubject() {
        return whichSubject;
    }

    public void setWhichSubject(String whichSubject) {
        this.whichSubject = whichSubject == null ? null : whichSubject.trim();
    }

    public Integer getWhichTime() {
        return whichTime;
    }

    public void setWhichTime(Integer whichTime) {
        this.whichTime = whichTime;
    }
}