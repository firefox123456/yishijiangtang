package com.huangqi.eduservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huangqi.eduservice.entity.EduChapter;
import com.huangqi.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author huangqi
 * @since 2022-07-11
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeVideoByCourseId(String courseId);
}
