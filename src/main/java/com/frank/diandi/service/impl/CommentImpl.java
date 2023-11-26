package com.frank.diandi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frank.diandi.common.Result;
import com.frank.diandi.dto.CommentDTO;
import com.frank.diandi.entity.Comment;
import com.frank.diandi.entity.User;
import com.frank.diandi.mapper.CommentMapper;
import com.frank.diandi.mapper.UserMapper;
import com.frank.diandi.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author frank
 * @date 2023/11/14
 **/
@Service
public class CommentImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<Boolean> createComment(CommentDTO commentDTO, Long userId) {
        User currentUser = userMapper.selectById(userId);

        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent())
                .setUserId(userId)
                .setArticleId(commentDTO.getArticleId())
                .setCreateBy(currentUser.getUserName())
                .setUpdateBy(currentUser.getUserName());
        int insert = commentMapper.insert(comment);
        if (insert == 1) {
            return Result.success("create new comment successful.", true);
        }
        return Result.failed("create new comment failed.", false);
    }

    @Override
    public Result<Boolean> updateComment(CommentDTO commentDTO, Long userId) {
        User currentUser = userMapper.selectById(userId);
        Comment comment = new Comment();
        comment.setUpdateBy(currentUser.getUserName())
                .setId(commentDTO.getCommentId())
                .setContent(commentDTO.getContent());
        int update = commentMapper.updateById(comment);
        if (update == 1) {
            return Result.success("update comment success.", true);
        }
        return Result.failed("update comment failed", false);
    }

}
