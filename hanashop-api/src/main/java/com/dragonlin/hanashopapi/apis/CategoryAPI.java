package com.dragonlin.hanashopapi.apis;

import com.dragonlin.hanashopapi.constants.PathConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({PathConstant.API_VERSION+"/category"})
public class CategoryAPI {
    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok().build();
    }
}
