package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "images")
public class ImageEntity {
    @Id
    private String id;
    @Column(name = "sourceaddress")
    private String sourceAddres;
    @Column(name = "productid")
    private String productId;
}
