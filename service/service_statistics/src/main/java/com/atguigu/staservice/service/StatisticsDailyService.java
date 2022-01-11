package com.atguigu.staservice.service;

import com.atguigu.staservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-09
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    //统计某一天的注册人数
    void createStatisticsByDay(String day);

    //图表显示，返回两部分数据，日期json数组，数量json数组
    Map<String, Object> getChartData(String begin, String end, String type);
}
