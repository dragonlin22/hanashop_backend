package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "tblproducts")
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String status;
    @Column(name = "createdate")
    private Date createAt;
    private int quantity;
    private double price;
    @Column(name = "categoryid")
    private String categoryId;
    private String description;
}
