package com.dragonlin.hanashopapi.services;

import com.dragonlin.hanashopapi.dtos.authen.AuthenResponseDTO;
import com.dragonlin.hanashopapi.dtos.authen.LoginDTO;

public interface IAuthenService {
    void loginFacebook();
    void loginGoogle();
    AuthenResponseDTO login(LoginDTO loginDTO);
    void regist();
}
