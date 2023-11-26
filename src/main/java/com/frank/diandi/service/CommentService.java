package com.frank.diandi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.CommentDTO;
import com.frank.diandi.entity.Comment;

/**
 * @author Frank
 */
public interface CommentService extends IService<Comment> {

    /**
     * create comment
     * @param commentDTO
     * @param userId
     * @return
     */
    Result<Boolean> createComment(CommentDTO commentDTO,Long userId);

    /**
     * update comment
     * @param commentDTO
     * @param userId
     * @return
     */
    Result<Boolean> updateComment(CommentDTO commentDTO,Long userId);


}
