package com.atguigu.educenter.service;

import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-06
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    //登录的方法
    String login(UcenterMember ucenterMember);

//    会员注册
    void register(RegisterVo registerVo);

    //根据openid查询是否存在用户
    UcenterMember getByOpenid(String openid);

    //查询某一天的注册人数
    Integer countRegisterByDay(String day);
}
