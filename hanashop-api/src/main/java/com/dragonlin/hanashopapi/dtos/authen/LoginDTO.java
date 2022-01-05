package com.dragonlin.hanashopapi.dtos.authen;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
    @NotBlank(message = "email is empty!")
    private String email;
    @NotBlank(message = "password is empty!")
    private String password;
}
