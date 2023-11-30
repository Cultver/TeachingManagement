package com.example.controller;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;
import java.io.File;

/**
 * web-management
 * 上传文件
 *
 * @autor WH
 * @data 2023~11~28~21:55
 * @motto 不满足是向上的车轮！
 */
@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image)throws Exception{
        log.info("文件上传:{},{},{}",username,age,image);
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();
        //构造唯一文件名-uuid

        image.transferTo(new File("F:\\images\\"+originalFilename));
        return Result.success();
    }

}
