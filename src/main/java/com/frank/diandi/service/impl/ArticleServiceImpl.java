package com.frank.diandi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleDTO;
import com.frank.diandi.entity.Article;
import com.frank.diandi.entity.User;
import com.frank.diandi.mapper.ArticleMapper;
import com.frank.diandi.mapper.UserMapper;
import com.frank.diandi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author frank
 * @date 2023/11/14
 **/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<Boolean> createArticle(ArticleDTO articleDTO, Long userId) {
        User currentUser = userMapper.selectById(userId);
        Article article = new Article();
        article.setTitle(articleDTO.getTitle())
                .setText(articleDTO.getText())
                .setCreateBy(currentUser.getUserName())
                .setUpdateBy(currentUser.getUserName())
                .setUserId(userId);
        int insert = articleMapper.insert(article);
        if (insert == 1) {
            return Result.success("create article success.", true);
        }
        return Result.failed("create article failed", false);
    }

    @Override
    public Result<Boolean> updateArticle(ArticleDTO articleDTO, Long userId) {
        Article currentArticle = articleMapper.selectById(articleDTO.getArticleId());
        User currentUser = userMapper.selectById(userId);
        if ((articleDTO.getText() == null) || (articleDTO.getTitle() == null)) {
            return Result.failed("update message cant be empty", false);
        }
        currentArticle.setUpdateBy(currentUser.getUserName())
                .setTitle(articleDTO.getTitle())
                .setText(articleDTO.getText());
        int updatedArticle = articleMapper.updateById(currentArticle);
        if (updatedArticle == 1) {
            return Result.success("update article successful", true);
        }

        return Result.failed("update article failed", false);

    }
}
