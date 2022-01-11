package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.frontvo.CourseQueryVo;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.entity.vo.CourseQuery;
import com.atguigu.eduservice.entity.vo.CourseWebVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author jachin
 * @since 2022-01-01
 */
public interface EduCourseService extends IService<EduCourse> {

    //保存课程和课程详情信息
    String saveCourseInfo(CourseInfoVo ourseInfoVo);

    //根据id获取课程信息
    CourseInfoVo getCourseInfoFormById(String id);

    //修改课程信息
    void updateCourseInfoById(CourseInfoVo courseInfoForm);

    //通过id获取课程信息
    CoursePublishVo getCoursePublishVoById(String id);

    //根据id发布课程
    boolean publishCourseById(String id);

    void pageQuery(Page<EduCourse> pageParam, CourseQuery courseQuery);

    //通过课程号删除课程
    boolean removeCourseById(String id);

    //通过老师id查询课程
    List<EduCourse> selectByTeacherId(String id);

    //查询课程列表
    Map<String, Object> pageListWeb(Page<EduCourse> pageParam, CourseQueryVo courseQuery);

    //查询显示的课程信息
    CourseWebVo selectInfoWebById(String courseId);
}
