package com.huanqi.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestExcel {
    public static void main(String[] args) {
//        文件名
    String filename="/Users/huangqi/Documents/online_edu/service/service_edu/src/test/java/com/huanqi/excel/write.xlsx";
//        List<DemoTest>list=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            DemoTest demoTest = new DemoTest();
//            demoTest.setSname("name"+i);
//            demoTest.setSno(i);
//            list.add(demoTest);
//        }

//    三种方法
//    EasyExcel.write(filename,DemoTest.class).sheet("学生列表").doWrite(list);
    EasyExcel.read(filename,DemoTest.class,new ExcleListener()).sheet().doRead();
    }
}
