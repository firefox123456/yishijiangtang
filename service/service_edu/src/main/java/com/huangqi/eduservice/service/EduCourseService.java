package com.huangqi.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huangqi.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huangqi.eduservice.entity.frontvo.CourseFrontVo;
import com.huangqi.eduservice.entity.frontvo.CourseWebVo;
import com.huangqi.eduservice.entity.vo.CourseInfoVo;
import com.huangqi.eduservice.entity.vo.CoursePublishVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author huangqi
 * @since 2022-07-11
 */
public interface EduCourseService extends IService<EduCourse> {


    public String saveCourseInfo(CourseInfoVo courseInfoVo);

    public CourseInfoVo getCourseinfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    public CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);
    //1 条件查询带分页查询课程前台
    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    //根据课程id，编写sql语句查询课程信息
    CourseWebVo getBaseCourseInfo(String courseId);
}
