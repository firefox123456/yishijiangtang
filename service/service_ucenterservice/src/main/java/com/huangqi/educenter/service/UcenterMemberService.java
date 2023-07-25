package com.huangqi.educenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huangqi.educenter.entity.UcenterMember;
import com.huangqi.educenter.entity.vo.RegisterVo;

public interface UcenterMemberService extends IService<UcenterMember> {

    //登录的方法
    String login(UcenterMember member);

    //注册的方法
    void register(RegisterVo registerVo);

    //根据openid判断
    UcenterMember getOpenIdMember(String openid);

    Integer countRegisterDay(String day);
}
