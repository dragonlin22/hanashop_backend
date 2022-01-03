package com.dragonlin.hanashopapi.dtos;

import lombok.Data;

@Data
public class AuthenResponseDTO {
    private String id;
    private String email;
    private String password;
    private String avatar;
    private String phone;
    private String github;
    private String linkedln;
    private String facebook;
    private String gitlab;
}

