package com.example.lianfang.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "学生实体类")
public class Student {
    @ApiModelProperty(name ="id", example = "123")
    private String id;

    @ApiModelProperty(name ="sdName", example = "James")
    private String sdName;

    @ApiModelProperty(name ="sex", example = "男")
    private String sex;

    @ApiModelProperty(name ="birth", example = "2019-11-18")
    private Date birth;

    @ApiModelProperty(name ="age",example = "19")
    private Integer age;
    @ApiModelProperty(name ="contact", example = "16688882222")
    private String contact;

    @ApiModelProperty(name ="email", example = "123@163.com")
    private String email;

    @ApiModelProperty(name ="mood", example = "Holy!")
    private String mood;

    @ApiModelProperty(name ="classNo", example = "12")
    private String classNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName == null ? null : sdName.trim();
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

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo == null ? null : classNo.trim();
    }
}