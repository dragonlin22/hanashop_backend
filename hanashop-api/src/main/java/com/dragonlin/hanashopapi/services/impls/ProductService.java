package com.dragonlin.hanashopapi.services.impls;

import com.dragonlin.hanashopapi.constants.FileConstant;
import com.dragonlin.hanashopapi.constants.PathConstant;
import com.dragonlin.hanashopapi.dtos.product.ProductDTO;
import com.dragonlin.hanashopapi.entities.ProductEntity;
import com.dragonlin.hanashopapi.repositories.IProductRepo;
import com.dragonlin.hanashopapi.services.IImageService;
import com.dragonlin.hanashopapi.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService implements IProductService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    IProductRepo productRepo;
    @Autowired
    IImageService imageService;
    public String save(ProductDTO productDTO, List<MultipartFile> images) throws Exception {
        ProductEntity productEntity= modelMapper.map(productDTO,ProductEntity.class);
        if(!StringUtils.hasLength(productDTO.getId())){
            String id= UUID.randomUUID().toString();
            productEntity.setId(id);
            productEntity.setCreateAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        }
        productRepo.save(productEntity);
        if(images!=null){
            Map<String,String> path= imageService.saveImage(productEntity.getId(),images, FileConstant.PRODUCT_IMAGE_FOLDER_PREFIX, PathConstant.PRODUCT_PATH_IMAGE);
            //
            String s=path.get(images.get(0).getOriginalFilename());
            // luu hinh
        }
        return productEntity.getId();
    }
}
