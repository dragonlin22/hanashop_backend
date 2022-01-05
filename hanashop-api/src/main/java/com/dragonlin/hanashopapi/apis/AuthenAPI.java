package com.dragonlin.hanashopapi.apis;

import com.dragonlin.hanashopapi.beans.JwtCustomBean;
import com.dragonlin.hanashopapi.constants.PathConstant;
import com.dragonlin.hanashopapi.constants.StringConstant;
import com.dragonlin.hanashopapi.dtos.authen.AuthenResponseDTO;
import com.dragonlin.hanashopapi.dtos.authen.LoginDTO;
import com.dragonlin.hanashopapi.services.IAuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({PathConstant.API_VERSION +"/authen"})
public class AuthenAPI extends BaseAPI{
    @Autowired
    private IAuthenService authenService;
    @Autowired
    JwtCustomBean jwtCustomBean;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO loginDTO){
        AuthenResponseDTO authenResponseDTO= authenService.login(loginDTO);
        if (authenResponseDTO != null) {
            List<String> exposeHeader= new ArrayList();
            String token= jwtCustomBean.generateJwtToken(authenResponseDTO.getId());
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set(StringConstant.AUTH_TOKEN,token);
            exposeHeader.add(StringConstant.AUTH_TOKEN);
            responseHeaders.setAccessControlExposeHeaders(exposeHeader);
            return ResponseEntity.ok().headers(responseHeaders).body(authenResponseDTO);
        }
        return ResponseEntity.badRequest().build();
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
