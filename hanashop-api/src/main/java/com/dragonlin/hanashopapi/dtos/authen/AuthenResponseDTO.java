package com.dragonlin.hanashopapi.dtos.authen;

import lombok.Data;

@Data
public class AuthenResponseDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String role;
}
