package com.example.springboot.controller;


import com.example.springboot.domain.result.Result;
import com.example.springboot.utils.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/common")
@CrossOrigin(origins="http://localhost:8080",allowCredentials = "true")
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        String url = aliOssUtil.upload(file);
        return Result.success(url);

    }
}
