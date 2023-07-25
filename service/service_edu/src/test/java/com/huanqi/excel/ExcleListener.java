package com.huanqi.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcleListener extends AnalysisEventListener<DemoTest> {
    @Override
    public void invoke(DemoTest demoTest, AnalysisContext analysisContext) {
        System.out.println("***"+demoTest);
    }
    @Override
    public void invokeHeadMap(Map<Integer,String> headMap, AnalysisContext context){
        System.out.println("表头"+headMap);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
