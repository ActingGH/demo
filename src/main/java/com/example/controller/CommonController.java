package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.R;
import com.example.entity.Content;
import com.example.entity.News;
import com.example.entity.Type;
import com.example.service.ContentService;
import com.example.service.NewsService;
import com.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {
    private final TypeService typeService;
    private final NewsService newsService;

    private final ContentService contentService;

    CommonController(TypeService typeService, NewsService newsService, ContentService contentService) {
        this.typeService = typeService;
        this.newsService = newsService;
        this.contentService = contentService;
    }


    @GetMapping("/news")
    public R<Page> getNews() {
        newsService.getNew();
        Page<News> pageInfo = new Page<>(1, 10);
        newsService.page(pageInfo);
        return R.success(pageInfo);
    }

    @GetMapping("/type")
    public R<Type> getType() {
        Type t = typeService.getById(1);
        return R.success(t);
    }


    @GetMapping("/content")
    public R<Page> getContent() {
        Page<Content> pageInfo = new Page<>(1, 10);
        contentService.page(pageInfo);
        return R.success(pageInfo);

    }
}
