package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Attending extends AttendingKey {
    @ApiModelProperty(name ="whichTerm",example = "第一学期" )
    private String whichTerm;
    @ApiModelProperty(name ="whicchYear",example = "第一学年" )
    private String whichYear;
    @ApiModelProperty(name ="isAttend",example = "1" )
    private String isAttend;
    @ApiModelProperty(name = "classNo",example = "1")
    private String classNo;
    private String sdName;

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getWhichTerm() {
        return whichTerm;
    }

    public void setWhichTerm(String whichTerm) {
        this.whichTerm = whichTerm == null ? null : whichTerm.trim();
    }

    public String getWhichYear() {
        return whichYear;
    }

    public void setWhichYear(String whichYear) {
        this.whichYear = whichYear == null ? null : whichYear.trim();
    }

    public String getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(String isAttend) {

        this.isAttend = isAttend == null ? null : isAttend.trim();
    }
}