package com.dragonlin.hanashopapi.services;

import com.dragonlin.hanashopapi.dtos.authen.AuthenResponseDTO;
import com.dragonlin.hanashopapi.dtos.authen.LoginDTO;
import com.dragonlin.hanashopapi.dtos.authen.RegistDTO;

public interface IAuthenService {
    void loginFacebook();

    void loginGoogle();

    AuthenResponseDTO login(LoginDTO loginDTO);

    String regist(RegistDTO registDTO);
}
