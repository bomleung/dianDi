package com.frank.diandi.controller;

import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleCreateDTO;
import com.frank.diandi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author frank
 * @date 2023/11/15
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/create")
    public Result<Boolean> createArticle(@RequestBody ArticleCreateDTO articleCreateDTO) {
        return articleService.createArticle(articleCreateDTO);
    }
}
