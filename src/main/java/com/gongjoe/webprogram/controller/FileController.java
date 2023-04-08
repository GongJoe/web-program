package com.gongjoe.webprogram.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Author: GongJoe
 * Date: 2023/4/7 10:19
 */
@RestController
public class FileController {
    @PostMapping("/upload")
    public String upload(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        System.out.println(photo.getOriginalFilename());  //图片的原始名称
        System.out.println(photo.getContentType());  //图片文件类型
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);
        return "上传成功";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();  //创建目录
        }
        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
