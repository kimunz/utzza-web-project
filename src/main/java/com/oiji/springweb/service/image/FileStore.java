package com.oiji.springweb.service.image;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Component
public class FileStore {

    @Value("${file.url}")
    private String fileUrl;

    public String getFullPath(String filename) {
        return fileUrl + filename;
    }

    public String storeImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hcmahtqcf",
                "api_key", "838731636127942",
                "api_secret", "cjp53EXeGqew_xSkrd2MVLLvY_k"));

        File convFile = convertMultiPartToFile(file);
        Map uploadResult = cloudinary.uploader().upload(convFile, ObjectUtils.emptyMap());
        String imgPath = createStoreFileName(uploadResult);

        return imgPath;
    }

    public String createStoreFileName(Map uploadResult) {
        String version = "v" + uploadResult.get("version").toString();
        String fileName = uploadResult.get("public_id").toString();
        String ext = uploadResult.get("format").toString();
        return version + "/" + fileName + "." + ext;
    }

    public String extractExt(String originalFileName) {
        int pos = originalFileName.lastIndexOf(".");
        return originalFileName.substring(pos + 1);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
