package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.chapter.VideoInfoForm;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-01
 */
public interface EduVideoService extends IService<EduVideo> {

    //查看章节是否有小节
    boolean getCountByChapterId(String chapterId);

    //保存小节
    void saveVideoInfo(VideoInfoForm videoInfoForm);

    //通过id获取小节
    VideoInfoForm getVideoInfoFormById(String id);

    //通过id更新小节
    void updateVideoInfoById(VideoInfoForm videoInfoForm);

    //根据id删除小节
    boolean removeVideoById(String id);

    //根据课程id删
    boolean removeByCourseId(String courseId);
}
