package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblOrderDetails")
@Data
public class OrderDetailEntity {
    @Id
    @Column(columnDefinition = "orderId")
    private String orderId;
    @Id
    @Column(columnDefinition = "productId")
    private String productId;
    private int quantity;
    private double price;
}
