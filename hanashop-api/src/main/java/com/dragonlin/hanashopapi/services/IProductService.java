package com.dragonlin.hanashopapi.services;

import com.dragonlin.hanashopapi.dtos.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {
    String save(ProductDTO blogDTO, List<MultipartFile> images) throws Exception;
}
