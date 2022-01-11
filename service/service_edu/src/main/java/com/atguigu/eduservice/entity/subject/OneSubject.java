package com.atguigu.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsxfa
 */
@Data
public class OneSubject {

    private String id;
    private String title;
    private List<TwoSubject> children = new ArrayList<>();

}
