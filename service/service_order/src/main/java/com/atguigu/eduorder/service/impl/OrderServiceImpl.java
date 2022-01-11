package com.atguigu.eduorder.service.impl;

import com.atguigu.commonutils.vo.CourseWebVoOrder;
import com.atguigu.commonutils.vo.UcenterMemberVo;
import com.atguigu.eduorder.client.EduClient;
import com.atguigu.eduorder.client.UcenterClient;
import com.atguigu.eduorder.entity.Order;
import com.atguigu.eduorder.mapper.OrderMapper;
import com.atguigu.eduorder.service.OrderService;
import com.atguigu.eduorder.utils.OrderNoUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author jachin
 * @since 2022-01-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduClient eduClient;
    @Autowired
    private UcenterClient ucenterClient;

    @Override
    public String saveOrder(String courseId, String memberId) {
        //通过远程调用根据用户id获取用户信息
        CourseWebVoOrder courseInfoOrder = eduClient.getCourseInfoOrder(courseId);
        System.out.println("用户的信息是：" + courseInfoOrder);
        //通过远程调用根据课程id获取课程信息
        UcenterMemberVo memberVo = ucenterClient.getInfo(memberId);

        //创建order对象，设置信息
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());//订单号
        order.setCourseId(courseId);
        order.setCourseTitle(courseInfoOrder.getTitle());
        order.setCourseCover(courseInfoOrder.getCover());
        order.setTeacherName("test");
        order.setTotalFee(courseInfoOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(memberVo.getMobile());
        order.setNickname(memberVo.getNickname());
        order.setStatus(0); // 0:未支付 1：已支付
        order.setPayType(1);//支付类型： 微信
        baseMapper.insert(order);

        return order.getOrderNo();
    }
}
