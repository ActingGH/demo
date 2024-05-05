package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.News;
import com.example.mapper.NewsMapper;
import com.example.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@Slf4j
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    public static String mySplit(String temp){
        return temp.split("<")[0];
    }
    @Override
    public boolean getNew()  {
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
            News news = new News();
            news.setId(i);
            news.setTitle(mySplit(ms[i]));
            this.updateById(news);
        }
        return true;
    }
}

