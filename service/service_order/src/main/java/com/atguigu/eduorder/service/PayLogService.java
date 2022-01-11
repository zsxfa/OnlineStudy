package com.atguigu.eduorder.service;

import com.atguigu.eduorder.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-08
 */
public interface PayLogService extends IService<PayLog> {

    //生成微信支付二维码
    Map createNative(String orderNo);

    //更新支付状态
    Map<String, String> queryPayStatus(String orderNo);

    //添加log并且修改支付状态
    void updateOrderStatus(Map<String, String> map);
}
