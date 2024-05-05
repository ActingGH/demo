package com.example;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.PageParam;
import com.example.common.R;
import com.example.common.StatusConstant;
import com.example.entity.Users;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.example.service.impl.NewsServiceImpl.mySplit;

/**
 * Unit test for simple App.
 */

@Slf4j
public class Baidu{
    @Test
    void baiduTest(){

        String url = "https://www.baidu.com/";
        Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            log.info("爬取新闻失败");
            throw new RuntimeException(e);
        }
        String[] ms=document.outerHtml().split("<span class=\"title-content-title\">");
        for(int i=1;i<=5;i++){
            System.out.println(mySplit(ms[i]));
        }


    }








}
