package com.example.server.controller;

import com.example.server.common.utils.CommonStaticUtils;
import com.example.server.service.S3Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController{

    @Autowired
    S3Utils s3Utils;

    @Autowired
    Environment env;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("multipartFile") MultipartFile multipartFile) throws Exception {
        if (multipartFile == null || multipartFile.isEmpty()){
            throw new Exception("file is empty");
        }
        String uploadFileName = multipartFile.getOriginalFilename();
        String fileExtension = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
        uploadFileName = CommonStaticUtils.getUuId() + "." + fileExtension;
        String uploadFileLocalPath = env.getProperty("upload_file_local_path") + File.separator + uploadFileName;
        File localFile = new File(uploadFileLocalPath);
//        multipartFile.transferTo(localFile);
//        File uploadFile = convert(multipartFile).orElseThrow(() -> new IllegalArgumentException("asdas"));
//        String url = s3Utils.uploadFile(localFile, uploadFileName);
        String url = s3Utils.uploadMultiPartFile(multipartFile, uploadFileName);
        return url;
    }

    @PostMapping("/upload_test")
    public String uploadFileTest(@RequestParam("multipartFile") MultipartFile multipartFile) throws Exception {
        if (multipartFile == null || multipartFile.isEmpty()){
            throw new Exception("file is empty");
        }
        String uploadFileName = multipartFile.getOriginalFilename();
        String fileExtension = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
        uploadFileName = CommonStaticUtils.getUuId() + "." + fileExtension;
        String uploadFileLocalPath = env.getProperty("upload_file_local_path") + File.separator + uploadFileName;
        File localFile = new File(uploadFileLocalPath);
//        multipartFile.transferTo(localFile);
//        File uploadFile = convert(multipartFile).orElseThrow(() -> new IllegalArgumentException("asdas"));
//        String url = s3Utils.uploadFile(localFile, uploadFileName);
        String url = s3Utils.uploadMultiPartFile(multipartFile, uploadFileName);
        return url;
    }

    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        if(convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }
}
