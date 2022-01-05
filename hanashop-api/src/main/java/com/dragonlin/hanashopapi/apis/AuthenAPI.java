package com.dragonlin.hanashopapi.apis;

import com.dragonlin.hanashopapi.beans.JwtCustomBean;
import com.dragonlin.hanashopapi.constants.PathConstant;
import com.dragonlin.hanashopapi.constants.StringConstant;
import com.dragonlin.hanashopapi.dtos.authen.AuthenResponseDTO;
import com.dragonlin.hanashopapi.dtos.authen.LoginDTO;
import com.dragonlin.hanashopapi.dtos.authen.RegistDTO;
import com.dragonlin.hanashopapi.dtos.response.ResponseWrapperDTO;
import com.dragonlin.hanashopapi.services.IAuthenService;
import com.dragonlin.hanashopapi.utils.LogUtil;
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
            LogUtil.log(this.getClass(),"login",LogUtil.INFO);
            return ResponseEntity.ok().headers(responseHeaders).body(authenResponseDTO);
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/regist")
    public ResponseEntity regist(@RequestBody RegistDTO registDTO){
        String id=authenService.regist(registDTO);
        ResponseWrapperDTO responseWrapperDTO= new ResponseWrapperDTO();
        if(id!=null){
            responseWrapperDTO.setData(id);
            responseWrapperDTO.setStatus(true);
            return ResponseEntity.ok().body(responseWrapperDTO);
        }
        responseWrapperDTO.setStatus(false);
        responseWrapperDTO.setMessage("email existed!");
        return ResponseEntity.badRequest().body(responseWrapperDTO);
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
