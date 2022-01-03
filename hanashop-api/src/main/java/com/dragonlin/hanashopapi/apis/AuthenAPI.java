package com.dragonlin.hanashopapi.apis;

import com.dragonlin.hanashopapi.constants.PathConstant;
import com.dragonlin.hanashopapi.services.IAuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({PathConstant.API_VERSION +"/auth"})
public class AuthenAPI extends BaseAPI{
    @Autowired
    private IAuthenService authenService;
    @PostMapping("/login")
    public ResponseEntity login(){
        authenService.login();
        return ResponseEntity.ok().build();
    }
    @PostMapping("/regist")
    public ResponseEntity regist(){
        authenService.regist();
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login/google")
    public  ResponseEntity loginGoogle(){
        authenService.loginGoogle();
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login/facebook")
    public  ResponseEntity loginFacebook(){
        authenService.loginFacebook();
        return ResponseEntity.ok().build();
    }
}
