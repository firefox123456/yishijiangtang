package com.huangqi.eduservice.service;

import com.huangqi.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huangqi.eduservice.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author huangqi
 * @since 2022-07-11
 */
public interface EduChapterService extends IService<EduChapter> {

    public List<ChapterVo> getChapterVideoByCourseId(String courseId);

    public boolean deleteChapter(String chapterId);

    void removeChapterById(String courseId);
}
