package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "support")
public class Support {
    @Id
    @Column(name = "SUPPORT_ID")
    private Integer supportId;

    @Column(name = "SUPPORT_NAME")
    private String supportName;

    @Column(name = "IMG")
    private String img;

    @Column(name = "CREATED_DATE")
    private java.sql.Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private java.sql.Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    public Integer getSupportId() {
        return this.supportId;
    }

    public void setSupportId(Integer supportId) {
        this.supportId = supportId;
    }

    public String getSupportName() {
        return this.supportName;
    }

    public void setSupportName(String supportName) {
        this.supportName = supportName;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public java.sql.Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.sql.Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.sql.Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(java.sql.Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
