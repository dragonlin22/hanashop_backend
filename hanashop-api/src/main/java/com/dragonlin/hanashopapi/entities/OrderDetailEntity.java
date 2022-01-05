package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tblOrderDetails")
@Data
@IdClass(OrderDetailEntity.class)
public class OrderDetailEntity implements Serializable {
    @Id
    @Column(columnDefinition = "orderId")
    private String orderId;
    @Id
    @Column(columnDefinition = "productId")
    private String productId;
    private int quantity;
    private double price;
}
