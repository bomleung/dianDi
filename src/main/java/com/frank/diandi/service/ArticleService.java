package com.frank.diandi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleDTO;
import com.frank.diandi.entity.Article;

/**
 * @author Frank
 */
public interface ArticleService extends IService<Article> {

    /**
     * create now post
     *
     * @param articleCreateDTO
     * @return post
     */
    Result<Boolean> createArticle(ArticleDTO articleCreateDTO, Long userId);

    /**
     * update post
     * @param articleUpdateDTO
     * @return
     */
    Result<Boolean> updateArticle(ArticleDTO articleUpdateDTO, Long userId);
}
