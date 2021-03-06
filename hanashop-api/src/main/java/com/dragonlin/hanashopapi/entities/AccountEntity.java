package com.dragonlin.hanashopapi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tblaccounts")
public class AccountEntity {
    @Id
    @Column(name = "userid")
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String role;
    private boolean status;
    private String password;
}
