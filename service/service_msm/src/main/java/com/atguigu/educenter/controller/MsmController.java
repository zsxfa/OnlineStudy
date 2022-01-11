package com.atguigu.educenter.controller;

import com.atguigu.commonutils.R;
import com.atguigu.educenter.service.MsmService;
import com.atguigu.educenter.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zsxfa
 */
@RestController
@RequestMapping("/edumsm")
//@CrossOrigin //跨域
public class MsmController {
    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping(value = "/send/{phone}")
    public R sendMsm(@PathVariable String phone) {
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)) return R.ok();

        code = RandomUtil.getFourBitRandom();
        Map<String,Object> param = new HashMap<>();
        param.put("code", code);
        boolean isSend = msmService.send(phone, "SMS_180051135", param);
        if(true) {
            redisTemplate.opsForValue().set(phone, code,5, TimeUnit.MINUTES);
            System.out.println("code: " + code);
            return R.ok();
        } else {
            return R.error().message("发送短信失败");
        }
    }
}
