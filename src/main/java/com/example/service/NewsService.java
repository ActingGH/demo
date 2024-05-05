package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.News;

import java.io.IOException;


public interface NewsService extends IService<News> {
    boolean getNew() ;
}
