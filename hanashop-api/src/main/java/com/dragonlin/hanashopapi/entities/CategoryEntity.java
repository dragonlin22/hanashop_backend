package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tblCategories")
public class CategoryEntity {
    @Id
    private String id;
    private String name;
}
