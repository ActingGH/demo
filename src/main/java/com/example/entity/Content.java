package com.example.entity;

import lombok.Data;

/**
 *
 */
@Data
public class Content {
    //线上总内容
    private int online;

    //投放中的内容
    private int putIn;

    //今日新增评论
    private int newComment;

    //较昨天增长量
    private double increase;

    //内容id
    private int id;


}
