package com.dragonlin.hanashopapi.dtos.authen;

import lombok.Data;

@Data
public class RegistDTO {
    private String email;
    private String phone;
    private String address;
    private String password;
}
