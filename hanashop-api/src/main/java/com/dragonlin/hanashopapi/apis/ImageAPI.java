package com.dragonlin.hanashopapi.apis;

import com.dragonlin.hanashopapi.constants.FileConstant;
import com.dragonlin.hanashopapi.constants.PathConstant;
import com.dragonlin.hanashopapi.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({PathConstant.API_VERSION+"/images"})
public class ImageAPI {
    @Autowired
    IImageService imageService;
    @GetMapping(path="/products/{product_id}/{image_name}",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity getImageProduct(@PathVariable("product_id")String productId, @PathVariable("image_name")String imageName){
        try{
            return ResponseEntity.ok().body(imageService.getImageFromIdAndName(FileConstant.PRODUCT_IMAGE_FOLDER_PREFIX,productId,imageName));
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().build();
    }
}
