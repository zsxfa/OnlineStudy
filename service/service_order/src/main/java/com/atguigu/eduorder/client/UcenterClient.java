package com.atguigu.eduorder.client;

import com.atguigu.commonutils.vo.UcenterMemberVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zsxfa
 */
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    //根据token字符串获取用户信息
    @GetMapping("/educenter/member/getInfo/{id}")
    public UcenterMemberVo getInfo(@PathVariable("id") String id);
}
