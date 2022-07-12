package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_gallery")
public class ProductGallery implements Serializable {
    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Id
    @Column(name = "GALLERY_ID")
    private Integer galleryId;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getGalleryId() {
        return this.galleryId;
    }

    public void setGalleryId(Integer galleryId) {
        this.galleryId = galleryId;
    }
}
