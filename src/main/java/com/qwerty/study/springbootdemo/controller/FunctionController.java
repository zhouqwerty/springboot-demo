package com.qwerty.study.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FunctionController {

    @Value("${spring.servlet.multipart.location}")
    private String UPLOAD_PATH;

    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file){
        System.out.println(file);
        try {
            byte[] bytes=file.getBytes();
            Path path= Paths.get(UPLOAD_PATH,file.getOriginalFilename());
            Files.write(path,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
}
