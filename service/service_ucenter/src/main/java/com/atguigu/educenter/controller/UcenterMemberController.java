package com.atguigu.educenter.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.commonutils.vo.UcenterMemberVo;
import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.entity.vo.RegisterVo;
import com.atguigu.educenter.service.UcenterMemberService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author jachin
 * @since 2022-01-06
 */
@RestController
@RequestMapping("/educenter/member")
//@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService ucenterMemberService;

    //登录
    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public R login(@RequestBody UcenterMember ucenterMember){
        String token = ucenterMemberService.login(ucenterMember);
        return R.ok().data("token", token);
    }

    //注册
    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo){
        ucenterMemberService.register(registerVo);
        return R.ok();
    }

    //根据token获取登录信息
    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("auth/getLoginInfo")
    public R getLoginInfo(HttpServletRequest request){
        try {
            String memberId = JwtUtils.getMemberIdByJwtToken(request);
            UcenterMember loginInfoVo = ucenterMemberService.getById(memberId);
            return R.ok().data("item", loginInfoVo);
        }catch (Exception e){
            e.printStackTrace();
            throw new GuliException(20001,"error");
        }
    }

    //根据token字符串获取用户信息
    @GetMapping("getInfo/{id}")
    public UcenterMemberVo getInfo(@PathVariable String id) {
        //根据用户id获取用户信息
        System.out.println("id是：" + id);
        UcenterMember ucenterMember = ucenterMemberService.getById(id);
        System.out.println("ucenterMember是：" + ucenterMember);

        UcenterMemberVo memeber = new UcenterMemberVo();
        BeanUtils.copyProperties(ucenterMember,memeber);

        return memeber;
    }

    //查询某一天的注册人数
    @GetMapping(value = "countRegister/{day}")
    public R registerCount(
            @PathVariable String day){
        Integer count = ucenterMemberService.countRegisterByDay(day);
        return R.ok().data("countRegister", count);
    }

}

