package com.atguigu.educenter.service;

import java.util.Map;

/**
 * @author zsxfa
 */
public interface MsmService {

    boolean send(String phone, String sms_180051135, Map<String, Object> param);
}
