package com.example.lianfang.entity;

public class HomeworkKey {
    private String id;

    private String whichSubject;

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