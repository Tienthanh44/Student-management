package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "gallery")
public class Gallery {
    @Id
    @Column(name = "GALLERY_ID")
    private Integer galleryId;

    @Column(name = "GALLERY_URL")
    private String galleryUrl;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private java.sql.Date createdDate;

    public Integer getGalleryId() {
        return this.galleryId;
    }

    public void setGalleryId(Integer galleryId) {
        this.galleryId = galleryId;
    }

    public String getGalleryUrl() {
        return this.galleryUrl;
    }

    public void setGalleryUrl(String galleryUrl) {
        this.galleryUrl = galleryUrl;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.sql.Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.sql.Date createdDate) {
        this.createdDate = createdDate;
    }
}
