package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import com.atguigu.commonutils.vo.UcenterMemberVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zsxfa
 */
@Component
@FeignClient(name="service-ucenter",fallback = UcenterClientImpl.class)
public interface UcenterClient {

    //根据用户id获取用户信息
    @GetMapping("/educenter/member/getInfo/{id}")
    public UcenterMemberVo getInfo(@PathVariable("id") String memberId);
}
