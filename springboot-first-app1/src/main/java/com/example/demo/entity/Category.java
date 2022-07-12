package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_DATE")
    private java.sql.Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private java.sql.Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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
