package com.dragonlin.hanashopapi.services.impls;

import com.dragonlin.hanashopapi.dtos.authen.AuthenResponseDTO;
import com.dragonlin.hanashopapi.dtos.authen.LoginDTO;
import com.dragonlin.hanashopapi.entities.AccountEntity;
import com.dragonlin.hanashopapi.repositories.IAccountRepo;
import com.dragonlin.hanashopapi.services.IAuthenService;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenService implements IAuthenService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    IAccountRepo accountRepo;
    @Override
    public AuthenResponseDTO login(LoginDTO loginDTO) {
        AccountEntity authenEntity = accountRepo.findByEmailAndStatus(loginDTO.getEmail(), true);
        if(authenEntity!=null){
            boolean checking = BCrypt.checkpw(loginDTO.getPassword(), authenEntity.getPassword());
            if (checking) {
//                authenEntity.setPassword("");
                AuthenResponseDTO authenResponseDTO=modelMapper.map(authenEntity,AuthenResponseDTO.class);
                return authenResponseDTO;
            }
        }
        return null;
    }

    @Override
    public void loginFacebook() {

    }

    @Override
    public void loginGoogle() {

    }



    @Override
    public void regist() {

    }
}
