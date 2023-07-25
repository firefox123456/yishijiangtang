package com.huangqi.oss.controller;

import com.huangqi.oss.service.OssService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "头像上传")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssControl {
    @Autowired
    private OssService ossService;

    @Transactional
    @PostMapping("/loadavatar")
    public R  uploadOssFile(MultipartFile file){
        String url=ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }

}
