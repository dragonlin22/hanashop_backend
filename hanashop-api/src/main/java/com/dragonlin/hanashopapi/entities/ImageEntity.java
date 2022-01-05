package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Images")
public class ImageEntity {
    @Id
    private String id;
    @Column(columnDefinition = "sourceAddress")
    private String sourceAddres;
    @Column(columnDefinition = "productId")
    private String productId;
}
