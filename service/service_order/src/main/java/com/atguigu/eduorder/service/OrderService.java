package com.atguigu.eduorder.service;

import com.atguigu.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-08
 */
public interface OrderService extends IService<Order> {

    //保存订单
    String saveOrder(String courseId, String memberIdByJwtToken);
}
