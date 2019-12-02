package com.example.lianfang.entity;

import io.swagger.annotations.ApiModelProperty;

public class FinalGrade extends FinalGradeKey {
    @ApiModelProperty(name = "year",example = "第一学年")
    private String year;
    @ApiModelProperty(name = "term",example = "第一学期")
    private String term;
    @ApiModelProperty(name = "checkClassAttendance",example = "100")
    private Float checkClassAttendance;
    @ApiModelProperty(name = "checkHomeaworkAttendance",example = "100")
    private Float checkHomeaworkAttendance;
    @ApiModelProperty(name = "midExam",example = "100")
    private Float midExam;
    @ApiModelProperty(name = "lastExam",example = "100")
    private Float lastExam;
    @ApiModelProperty(name = "grades",example = "100")
    private Float grades;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Float getCheckClassAttendance() {
        return checkClassAttendance;
    }

    public void setCheckClassAttendance(Float checkClassAttendance) {
        this.checkClassAttendance = checkClassAttendance;
    }

    public Float getCheckHomeaworkAttendance() {
        return checkHomeaworkAttendance;
    }

    public void setCheckHomeaworkAttendance(Float checkHomeaworkAttendance) {
        this.checkHomeaworkAttendance = checkHomeaworkAttendance;
    }

    public Float getMidExam() {
        return midExam;
    }

    public void setMidExam(Float midExam) {
        this.midExam = midExam;
    }

    public Float getLastExam() {
        return lastExam;
    }

    public void setLastExam(Float lastExam) {
        this.lastExam = lastExam;
    }

    public Float getGrades() {
        return grades;
    }

    public void setGrades(Float grades) {
        this.grades = grades;
    }
}