package com.frank.diandi.controller;

import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleDTO;
import com.frank.diandi.entity.Article;
import com.frank.diandi.entity.User;
import com.frank.diandi.service.ArticleService;
import com.frank.diandi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author frank
 * @date 2023/11/15
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getArticleList")
    public Result<List<Article>> getArticleList(@RequestHeader(value = "token", required = true) String token) {
        User currentUser = userService.getUserByToken(token);
        return articleService.getArticleList(currentUser.getId());
    }

    @RequestMapping("/create")
    public Result<Boolean> createArticle(@RequestBody ArticleDTO articleDTO, @RequestHeader(value = "token", required = true) String token) {
        User currentUser = userService.getUserByToken(token);
        return articleService.createArticle(articleDTO, currentUser.getId());
    }

    @RequestMapping("/update")
    public Result<Boolean> updateArticle(@RequestBody ArticleDTO articleDTO, @RequestHeader(value = "token", required = true) String token) {
        User currentUser = userService.getUserByToken(token);
        return articleService.updateArticle(articleDTO, currentUser.getId());
    }

    @RequestMapping("/remove")
    public Result<Boolean> deleteArticle(@RequestBody ArticleDTO articleDTO, @RequestHeader(value = "token", required = true) String token) {
        boolean remove = articleService.removeById(articleDTO.getArticleId());
        if (remove) {
            return Result.success("remove article success.", true);
        }
        return Result.failed("remove article failed", false);
    }
}
