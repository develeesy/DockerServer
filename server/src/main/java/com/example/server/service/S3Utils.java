//package com.example.server.service;
//
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Optional;
//
//@Service
//public class S3Utils {
//
//    @Autowired
//    Environment env;
//
//    // 이미 s3 는 Bean으로 등록되어 있어서 가져다 쓰면되는건가?
//    @Autowired
//    public AmazonS3Client amazonS3Client;
//
//    public String uploadFile(File localFile, String s3FilePath){
//        String s3Bucket = env.getProperty("cloud.aws.s3.bucket");
//        amazonS3Client.putObject(new PutObjectRequest(s3Bucket, s3FilePath, localFile).withCannedAcl(CannedAccessControlList.PublicRead));
//        return amazonS3Client.getUrl(s3Bucket, s3FilePath).toString();
//    }
//
//    public String uploadMultiPartFile(MultipartFile localFile, String s3FilePath) throws IOException {
//        String s3Bucket = env.getProperty("cloud.aws.s3.bucket");
//        amazonS3Client.putObject(new PutObjectRequest(s3Bucket, s3FilePath, localFile.getInputStream(), null).withCannedAcl(CannedAccessControlList.PublicRead));
//        return amazonS3Client.getUrl(s3Bucket, s3FilePath).toString();
//    }
//
//    public String getProperties(){
//        return env.getProperty("cloud.aws.s3.bucket");
//    }
//
//
//}
