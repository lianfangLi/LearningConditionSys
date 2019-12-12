package com.example.lianfang.entity;

public class HomeworkExtends extends Homework {

    private Integer isAttendResult;

    private String courName;

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public Integer getIsAttendResult() {
        return isAttendResult;
    }

    public void setIsAttendResult(Integer isAttendResult) {
        this.isAttendResult = isAttendResult;
    }
}
