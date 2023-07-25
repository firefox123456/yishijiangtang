package com.huangqi.eduservice.service;

import com.huangqi.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huangqi.eduservice.entity.subjectvo.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author huangqi
 * @since 2022-07-10
 */
public interface EduSubjectService extends IService<EduSubject> {

    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

    public  List<OneSubject> getAllOneTwoSubject();
}
