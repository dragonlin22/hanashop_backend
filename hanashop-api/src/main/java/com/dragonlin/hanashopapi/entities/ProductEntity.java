package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tblProducts")
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String status;
    @Column(columnDefinition = "createDate")
    private Date createAt;
    private int quantity;
    private double price;
    @Column(columnDefinition = "categoryId")
    private String categoryId;
    private String description;
}
