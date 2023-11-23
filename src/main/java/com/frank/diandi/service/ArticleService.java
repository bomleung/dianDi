package com.frank.diandi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleDTO;
import com.frank.diandi.entity.Article;

import java.util.List;

/**
 * @author Frank
 */
public interface ArticleService extends IService<Article> {

    /**
     * get article list
     * @param userId
     * @return article list
     */
    Result<List<Article>> getArticleList(Long userId);

    /**
     * create now post
     *
     * @param articleCreateDTO
     * @param userId
     * @return post
     */
    Result<Boolean> createArticle(ArticleDTO articleCreateDTO, Long userId);

    /**
     * update post
     * @param articleUpdateDTO
     * @param userId
     * @return
     */
    Result<Boolean> updateArticle(ArticleDTO articleUpdateDTO, Long userId);
}
