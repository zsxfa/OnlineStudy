package com.atguigu.eduservice.client;

import org.springframework.stereotype.Component;

/**
 * @author zsxfa
 */
@Component
public class OrdersClientImpl implements OrdersClient{

    @Override
    public boolean isBuyCourse(String courseId, String memberId) {
        return false;
    }
}
