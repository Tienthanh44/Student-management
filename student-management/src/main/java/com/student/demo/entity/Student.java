package com.student.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "StudentName")
    private String studentName;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Address")
    private String address;

    @Column(name = "CreatedDate")
    private java.util.Date createdDate;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
}
