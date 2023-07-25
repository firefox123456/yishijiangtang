package com.huangqi.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huangqi.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author huangqi
 * @since 2022-06-30
 */
public interface EduTeacherService extends IService<EduTeacher> {

    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
