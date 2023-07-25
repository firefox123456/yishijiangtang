package com.huangqi.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huangqi.eduservice.entity.EduSubject;
import com.huangqi.eduservice.entity.excle.SubjectData;
import com.huangqi.eduservice.service.EduSubjectService;
import com.huangqi.servicebase.exceptionhandler.Myexception;

public class SubjectExcleListener extends AnalysisEventListener<SubjectData> {
    public EduSubjectService eduSubjectService;

    public SubjectExcleListener() {
    }

    public SubjectExcleListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new Myexception(2001, "文件数据为空！");
        }
        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if (existOneSubject == null) {
            existOneSubject=new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(existOneSubject);
        }
        String pid=existOneSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(), pid);
        if ( existTwoSubject== null) {
            existTwoSubject=new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());
            eduSubjectService.save(existTwoSubject);
        }
    }

    private EduSubject existOneSubject(EduSubjectService eduSubjectService, String name) {
        QueryWrapper<EduSubject> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("title", name);
        objectQueryWrapper.eq("parent_id", "0");
        EduSubject oneSubject = eduSubjectService.getOne(objectQueryWrapper);
        return oneSubject;
    }

    private EduSubject existTwoSubject(EduSubjectService eduSubjectService, String name,String pid) {
        QueryWrapper<EduSubject> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("title", name);
        objectQueryWrapper.eq("parent_id", pid);
        EduSubject twoSubject = eduSubjectService.getOne(objectQueryWrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
