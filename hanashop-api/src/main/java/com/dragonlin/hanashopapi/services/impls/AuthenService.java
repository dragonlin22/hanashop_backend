package com.dragonlin.hanashopapi.services.impls;

import com.dragonlin.hanashopapi.constants.RoleConstant;
import com.dragonlin.hanashopapi.constants.StringConstant;
import com.dragonlin.hanashopapi.dtos.authen.AuthenResponseDTO;
import com.dragonlin.hanashopapi.dtos.authen.LoginDTO;
import com.dragonlin.hanashopapi.dtos.authen.RegistDTO;
import com.dragonlin.hanashopapi.entities.AccountEntity;
import com.dragonlin.hanashopapi.repositories.IAccountRepo;
import com.dragonlin.hanashopapi.services.IAuthenService;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public String regist(RegistDTO registDTO) {
        if(accountRepo.findByEmail(registDTO.getEmail())!=null){
            return null;
        }
        AccountEntity accountEntity= modelMapper.map(registDTO,AccountEntity.class);
        accountEntity.setId(UUID.randomUUID().toString());
        accountEntity.setStatus(true);
        String password=BCrypt.hashpw(registDTO.getPassword(),BCrypt.gensalt(StringConstant.SALT_BCRYPT));
        accountEntity.setPassword(password);
        accountEntity.setRole(RoleConstant.USER);
        accountRepo.save(accountEntity);
        return accountEntity.getId();
    }
}
