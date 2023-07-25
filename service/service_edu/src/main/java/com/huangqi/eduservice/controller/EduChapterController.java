package com.huangqi.eduservice.controller;


import com.huangqi.commonutils.R;
import com.huangqi.eduservice.entity.EduChapter;
import com.huangqi.eduservice.entity.chapter.ChapterVo;
import com.huangqi.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "章节管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/educhapter")
public class EduChapterController {

    @Autowired
    EduChapterService eduChapterService;

    @ApiOperation("得到所有章节")
    @GetMapping("getchaptervideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId){
        List<ChapterVo> chapterVideoByCourseId = eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("list",chapterVideoByCourseId);
    }
    //添加章节
    @ApiOperation("添加章节")
    @PostMapping("addChapter")
    public R addChapter(@RequestBody EduChapter eduChapter) {
        eduChapterService.save(eduChapter);
        return R.ok();
    }

    //根据章节id查询
    @ApiOperation("根据章节id查询")
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfo(@PathVariable String chapterId) {
        EduChapter eduChapter = eduChapterService.getById(chapterId);
        return R.ok().data("chapter",eduChapter);
    }

    //修改章节
    @ApiOperation("修改章节")
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter) {
        eduChapterService.updateById(eduChapter);
        return R.ok();
    }

    //删除的方法
    @ApiOperation("删除章节")
    @DeleteMapping("delete/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId) {
        boolean flag = eduChapterService.deleteChapter(chapterId);
        if(flag) {
            return R.ok();
        } else {
            return R.error();
        }

    }
}

