package com.example.lianfang.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel()
public class Teacher {
    @ApiModelProperty(name ="教师编号", value = "teachId" ,example = "17111")
    private String teacherId;
    @ApiModelProperty(name ="教师姓名", value = "teacherName" ,example = "马")
    private String teacherName;

    @ApiModelProperty(name ="性别", value = "sex" ,example = "男")
    private String sex;
    @ApiModelProperty(name ="教师出生日期 格式固定", value = "birth" ,example = "2019-12-22")
    private Date birth;
    @ApiModelProperty(name ="教师年龄", value = "age" ,example = "56")
    private Integer age;
    @ApiModelProperty(name ="电话", value = "contact" ,example = "13888885555")
    private String contact;
    @ApiModelProperty(name ="邮箱", value = "email" ,example = "whatever@163.com")
    private String email;
    @ApiModelProperty(name ="签名", value = "mood" ,example = "what’s this？")
    private String mood;
    @ApiModelProperty(name ="职称", value = "rank" ,example = "教授")
    private String rank;
    @ApiModelProperty(name ="所在系的系号", value = "dpId" ,example = "1")
    private Integer dpId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }
}