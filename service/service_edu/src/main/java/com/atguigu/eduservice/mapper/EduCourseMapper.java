package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.entity.vo.CourseWebVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author jachin
 * @since 2022-01-01
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    CoursePublishVo selectCoursePublishVoById(String id);

    CourseWebVo selectInfoWebById(String courseId);
}
