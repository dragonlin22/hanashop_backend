package com.dragonlin.hanashopapi.apis;

import com.dragonlin.hanashopapi.constants.PathConstant;
import com.dragonlin.hanashopapi.dtos.product.ProductDTO;
import com.dragonlin.hanashopapi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping({PathConstant.API_VERSION+"/products"})
public class ProductAPI extends BaseAPI {
    @Autowired
    IProductService productService;
    @PostMapping("/auth")
    public ResponseEntity insert(@RequestPart(value = "images", required = false) MultipartFile[] imageShow,
                                 @Valid @RequestPart(value = "product") ProductDTO productDTO) {
        try {
            List<MultipartFile> imageShowList = Arrays.asList(imageShow);
            String id=productService.save(productDTO, imageShowList);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().build();
    }
}
