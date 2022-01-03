package com.dragonlin.hanashopapi.services.impls;

import com.dragonlin.hanashopapi.constants.FileConstant;
import com.dragonlin.hanashopapi.services.IImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.aspectj.util.FileUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageService implements IImageService {
    @Value("${spring.application.name}")
    private String serviceName;
    @Value("${host.uri}")
    private String hostUri;
    @Value("${server.servlet.context-path}")
    private String contextPath;
    public static final String PATH_IMAGE = System.getProperty("user.home") + "/my-blog";


    public Map<String, String> saveImage(String itemId, List<MultipartFile> images, String prefixFolder, String prefixPath) throws Exception {
        File uploadRootDir = new File(PATH_IMAGE);
        // create folder save image
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdir();
        }
        // create blog folder in folder image
        File uploadBlogDir = new File(PATH_IMAGE + File.separator + prefixFolder + itemId);
        if (!uploadBlogDir.exists()) {
            uploadBlogDir.mkdir();
        }
        Map<String, String> paths = new HashMap<>();
        for (MultipartFile multipartFile : images) {
            //file image
            String name = multipartFile.getOriginalFilename();
            if (StringUtils.hasLength(name)) {
                File serverFile = new File(uploadBlogDir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(multipartFile.getBytes());
                stream.close();
                paths.put(name, serverPathImage(itemId, name, prefixPath));
            }
        }
        return paths;
    }

    private String serverPathImage(String itemId, String imageName, String prefixPath) {
        return hostUri+"/"+serviceName+contextPath+"/image" + "/" + prefixPath + "/" + itemId + "/" + imageName;
    }


    public byte[] getImageFromIdAndName(String prefix, String itemId, String imageName) throws Exception {
        String path = PATH_IMAGE + File.separator + prefix + itemId + File.separator + imageName;
        return Files.readAllBytes(Paths.get(path));
    }

    public String getPathFolder(String itemId, String prefix) {
        return PATH_IMAGE + File.separator + prefix + itemId;
    }

    public boolean deleteImage(String id, String folderPrefix) throws Exception {
        String pathFolder = getPathFolder(id, folderPrefix);
        File file = new File(pathFolder);
        if (file.exists()) {
            if (file.isDirectory()) {
                FileUtil.deleteContents(file);
            }
            return file.delete();
        }
        return false;
    }
}
