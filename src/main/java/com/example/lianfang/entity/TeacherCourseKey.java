package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TeacherCourseKey {
    @ApiModelProperty(name ="teacherId", example = "17111")
    private String teacherId;
    @ApiModelProperty(name ="className", example = "软件工程")
    private String className;
    @ApiModelProperty(name ="courNo", example = "1")
    private String courNo;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getCourNo() {
        return courNo;
    }

    public void setCourNo(String courNo) {
        this.courNo = courNo == null ? null : courNo.trim();
    }
}