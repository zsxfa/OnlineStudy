package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.chapter.VideoInfoForm;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author jachin
 * @since 2022-01-01
 */
@Api(description="课时管理")
@RestController
@CrossOrigin //跨域
@RequestMapping("/eduservice/eduVideo")
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;
    //注入vodClient
    @Autowired
    private VodClient vodClient;

    @ApiOperation(value = "新增课时")
    @PostMapping("saveVideoInfo")
    public R save(
            @ApiParam(name = "videoForm", value = "课时对象", required = true)
            @RequestBody VideoInfoForm videoInfoForm) {

        videoService.saveVideoInfo(videoInfoForm);
        return R.ok();
    }


    @ApiOperation(value = "根据ID查询课时")
    @GetMapping("videoInfo/{id}")
    public R getVideInfoById(
            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id) {

        VideoInfoForm videoInfoForm = videoService.getVideoInfoFormById(id);
        return R.ok().data("item", videoInfoForm);
    }

    @ApiOperation(value = "更新课时")
    @PutMapping("updateVideoInfo/{id}")
    public R updateCourseInfoById(
            @ApiParam(name = "VideoInfoForm", value = "课时基本信息", required = true)
            @RequestBody VideoInfoForm videoInfoForm,

            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id) {

        videoService.updateVideoInfoById(videoInfoForm);
        return R.ok();
    }

    //删除小节
    @ApiOperation(value = "根据ID删除课时")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "课时ID", required = true)
            @PathVariable String id){

        //先根据小节id查到视频id，再删除
        EduVideo eduVideo = videoService.getById(id);
        String videoSourceId = eduVideo.getVideoSourceId();
        //判断小节是否有视频id
        if(!StringUtils.isEmpty(videoSourceId)){
            R result = vodClient.removeVideo(videoSourceId);
            if(result.getCode() == 20001){
                throw new GuliException(20001,"删除视频失败，熔断器...");
            }
        }
        //删除小节
        boolean result = videoService.removeVideoById(id);
        return result == true ? R.ok() : R.error().message("删除失败");
    }



}

