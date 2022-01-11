package com.atguigu.educms.service;

import com.atguigu.educms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-05
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> selectIndexList();
}
