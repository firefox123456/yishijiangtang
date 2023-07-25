package com.huangqi.eduservice.entity.subjectvo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneSubject {

    private String id;

    private String title;

    private List<TwoSubject> list=new ArrayList<>();

}
