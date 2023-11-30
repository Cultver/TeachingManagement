package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
    @Autowired
    private AliOSSUtils aliOSSUtils;
    //本地存储
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image)throws Exception{
//        log.info("文件上传:{},{},{}",username,age,image);
//        //获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//        //构造唯一文件名-uuid 5cf66bb8-2163-48dc-8925-e76e6087e546
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("newFileName: {}",newFileName);
//
//        image.transferTo(new File("F:\\images\\"+newFileName));
//        return Result.success();
//    }
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("fileupload: {}",image.getOriginalFilename());
        //调用阿里云工具类，上传文件传入阿里云
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url：{}",url);
        //图片上传完成后URL返回，用于浏览器回显
        return  Result.success(url);
    }

}
