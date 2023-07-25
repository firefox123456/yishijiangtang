package com.huangqi.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huangqi.eduservice.entity.EduSubject;
import com.huangqi.eduservice.entity.excle.SubjectData;
import com.huangqi.eduservice.entity.subjectvo.OneSubject;
import com.huangqi.eduservice.entity.subjectvo.TwoSubject;
import com.huangqi.eduservice.listener.SubjectExcleListener;
import com.huangqi.eduservice.mapper.EduSubjectMapper;
import com.huangqi.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author huangqi
 * @since 2022-07-10
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcleListener(eduSubjectService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    暴力循环，因为课程数目不会太大，后期可优化



    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", "0");
        List<EduSubject> oneSubject = baseMapper.selectList(queryWrapper);

        QueryWrapper<EduSubject> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.ne("parent_id", "0");
        List<EduSubject> twoSubject = baseMapper.selectList(queryWrapper1);

        List<OneSubject> finalSubjectList = new ArrayList<>();

        for (int i = 0; i < oneSubject.size(); i++) {
            EduSubject eduSubject = oneSubject.get(i);
            OneSubject oneSubject1 = new OneSubject();
//              oneSubject1.setId(eduSubject.getId());
//              oneSubject1.setTitle(eduSubject.getTitle());
            finalSubjectList.add(oneSubject1);
            BeanUtils.copyProperties(eduSubject, oneSubject1);

            ArrayList<TwoSubject> twoSubjectList = new ArrayList<>();

            for (int i1 = 0; i1 < twoSubject.size(); i1++) {
                EduSubject eduSubject1 = twoSubject.get(i1);

                if (eduSubject.getId().equals(eduSubject1.getParentId())){
                    TwoSubject twoSubject1 = new TwoSubject();
                    BeanUtils.copyProperties(eduSubject1, twoSubject1);
                    twoSubjectList.add(twoSubject1);
                }
            }
            oneSubject1.setList(twoSubjectList);
        }
        return finalSubjectList;
    }
}
