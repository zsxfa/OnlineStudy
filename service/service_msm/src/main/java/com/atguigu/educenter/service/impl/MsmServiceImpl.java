package com.atguigu.educenter.service.impl;

import com.atguigu.educenter.service.MsmService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zsxfa
 */
@Service
public class MsmServiceImpl implements MsmService {

    //发送短信
    @Override
    public boolean send(String phone, String sms_180051135, Map<String, Object> param) {
//        if(StringUtils.isEmpty(PhoneNumbers)) return false;
//
//        DefaultProfile profile =
//                DefaultProfile.getProfile("default", "LTAIq6nIPY09VROj", "FQ7UcixT9wEqMv9F35nORPqKr8XkTF");
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        //request.setProtocol(ProtocolType.HTTPS);
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//
//        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
//        request.putQueryParameter("SignName", "我的谷粒在线教育网站");
//        request.putQueryParameter("TemplateCode", templateCode);
//        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
//
//        try {
//            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
//            return response.getHttpResponse().isSuccess();
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }
        return false;
    }
}
