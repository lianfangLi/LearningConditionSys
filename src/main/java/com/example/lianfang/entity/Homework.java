package com.example.lianfang.entity;

public class Homework extends HomeworkKey {
    private String isAttend;

    private String whichTerm;

    private String whichYear;

    public String getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(String isAttend) {
        this.isAttend = isAttend == null ? null : isAttend.trim();
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
}