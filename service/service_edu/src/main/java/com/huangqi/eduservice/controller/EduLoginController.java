package com.huangqi.eduservice.controller;

import com.huangqi.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    @ApiOperation("用户登陆功能")
    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }


    @ApiOperation("用户信息展示")
    @GetMapping("info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://huanqi-online-education.oss-cn-beijing.aliyuncs.com/2022/07/07/fba7aa6a38f645ff84121c743e7303f5f778738c-e4f8-4870-b634-56703b4acafe%20%281%29.gif");
    }
}
