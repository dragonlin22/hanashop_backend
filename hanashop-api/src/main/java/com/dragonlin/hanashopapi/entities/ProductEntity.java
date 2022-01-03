package com.dragonlin.hanashopapi.entities;

import lombok.Data;

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
    private Date createAt;
}
