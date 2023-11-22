package com.frank.diandi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleCreateDTO;
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
    public Result<Boolean> createArticle(ArticleCreateDTO articleCreateDTO) {
        User currentUser = userMapper.selectById(articleCreateDTO.getUserId());
        Article article = new Article();
        article.setTitle(articleCreateDTO.getTitle())
                .setText(articleCreateDTO.getText())
                .setUserId(articleCreateDTO.getUserId())
                .setCreateBy(currentUser.getUserName())
                .setUpdateBy(currentUser.getUserName());
        int insert = articleMapper.insert(article);
        if (insert == 1) {
            return Result.success("create article success.", true);
        }
        return Result.failed("create article failed", false);
    }
}
