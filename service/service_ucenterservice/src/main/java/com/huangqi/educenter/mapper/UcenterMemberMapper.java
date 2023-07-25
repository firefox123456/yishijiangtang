package com.huangqi.educenter.mapper;

import com.huangqi.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author huangqi
 * @since 2022-07-26
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {
    //查询某一天注册人数
    Integer countRegisterDay(String day);
}
