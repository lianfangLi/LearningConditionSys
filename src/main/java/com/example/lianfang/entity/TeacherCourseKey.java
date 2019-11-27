package com.example.lianfang.entity;

public class TeacherCourseKey {
    private String teacherId;

    private String stuClass;

    private String courNo;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass == null ? null : stuClass.trim();
    }

    public String getCourNo() {
        return courNo;
    }

    public void setCourNo(String courNo) {
        this.courNo = courNo == null ? null : courNo.trim();
    }
}