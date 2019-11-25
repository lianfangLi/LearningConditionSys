package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class StudentAttending {
    @ApiModelProperty(name ="id", example = "123")

    private String id;
    @ApiModelProperty(name ="sdName", example = "James")
    private String sdName;

    private String whichSubject;

    private String whichTime;

    private String isAttend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public String getWhichSubject() {
        return whichSubject;
    }

    public void setWhichSubject(String whichSubject) {
        this.whichSubject = whichSubject;
    }

    public String getWhichTime() {
        return whichTime;
    }

    public void setWhichTime(String whichTime) {
        this.whichTime = whichTime;
    }

    public String getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(String isAttend) {
        this.isAttend = isAttend;
    }
}
