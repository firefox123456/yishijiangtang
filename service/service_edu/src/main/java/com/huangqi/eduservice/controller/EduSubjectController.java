package com.huangqi.eduservice.controller;


import com.huangqi.commonutils.R;
import com.huangqi.eduservice.entity.EduSubject;
import com.huangqi.eduservice.entity.subjectvo.OneSubject;
import com.huangqi.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author huangqi
 * @since 2022-07-10
 */
@Api(tags = "课程分类管理")
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @ApiOperation("添加课程分类")
    @PostMapping("addsubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }
    @ApiOperation("课程列表分类数据")
    @GetMapping("getallsubject")
    public R getAllSubject(){
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }
}

