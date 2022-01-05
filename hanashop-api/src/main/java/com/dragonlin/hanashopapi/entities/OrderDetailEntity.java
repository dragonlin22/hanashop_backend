package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblorderdetails")
@Data
@IdClass(OrderDetailEntity.class)
public class OrderDetailEntity implements Serializable {
    @Id
    @Column(name = "orderId")
    private String orderId;
    @Id
    @Column(name = "productId")
    private String productId;
    private int quantity;
    private double price;
}
