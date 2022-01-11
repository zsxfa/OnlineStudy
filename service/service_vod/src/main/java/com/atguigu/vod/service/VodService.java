package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    //删除视频
    void removeVideo(String videoId);

    //删除章节
    void removeVideoList(List videoIdList);
}
