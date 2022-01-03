package com.dragonlin.hanashopapi.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IImageService {
    Map<String, String> saveImage(String itemId, List<MultipartFile> images, String prefixFolder, String prefixPathAccess) throws Exception;

    byte[] getImageFromIdAndName(String prefix, String blogId, String imageName) throws Exception;

    String getPathFolder(String itemId, String prefix);

    boolean deleteImage(String id, String folderPrefix) throws Exception;
}
