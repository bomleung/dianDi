package com.frank.diandi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.ArticleCreateDTO;
import com.frank.diandi.entity.Article;

/**
 * @author Frank
 */
public interface ArticleService extends IService<Article> {

    /**
     * create now post
     * @param articleCreateDTO
     * @return post
     */
    Result<Boolean> createArticle(ArticleCreateDTO articleCreateDTO);
}
