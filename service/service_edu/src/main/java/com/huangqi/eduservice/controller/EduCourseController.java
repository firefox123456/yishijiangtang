package com.huangqi.eduservice.controller;


import com.huangqi.commonutils.R;
import com.huangqi.eduservice.entity.EduCourse;
import com.huangqi.eduservice.entity.EduCourseDescription;
import com.huangqi.eduservice.entity.vo.CourseInfoVo;
import com.huangqi.eduservice.entity.vo.CoursePublishVo;
import com.huangqi.eduservice.service.EduCourseDescriptionService;
import com.huangqi.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author huangqi
 * @since 2022-07-11
 */
@RestController
@CrossOrigin
@Api(tags = "课程管理")
@RequestMapping("/eduservice/educourse")
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    @ApiOperation("添加课程")
    @PostMapping("addcourseinfo")
    @Transactional
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {

        String id = eduCourseService.saveCourseInfo(courseInfoVo);

        return R.ok().data("courseId", id);
    }

    @ApiOperation("根据课程id查询基本信息")
    @GetMapping("getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId) {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseinfo(courseId);
        return R.ok().data("courseInfovo", courseInfoVo);
    }

    @ApiOperation("修改课程基本信息")
    @PostMapping("updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }
    @ApiOperation(("根据课程id查询确认信息"))
    @GetMapping("/getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id){
        CoursePublishVo coursePublishVo=eduCourseService.publishCourseInfo(id);
        return R.ok().data("publishCourse",coursePublishVo);
    }
    //课程最终发布
    //修改课程状态
    @ApiOperation("修改课程状态")
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");//设置课程发布状态
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }

    //删除课程
    @ApiOperation("删除课程")
    @DeleteMapping("delete/{courseId}")
    public R deleteCourse(@PathVariable String courseId) {

        eduCourseService.removeCourse(courseId);

        return R.ok();
    }
    //课程列表 基本实现
    //TODO  完善条件查询带分页
    @ApiOperation("回显课程列表")
    @GetMapping("publish")
    public R getCourseList() {
        List<EduCourse> list = eduCourseService.list(null);
        return R.ok().data("list",list);
    }
}

