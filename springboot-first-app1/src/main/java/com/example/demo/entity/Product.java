package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "CREATED_DATE")
    private java.sql.Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private java.sql.Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
