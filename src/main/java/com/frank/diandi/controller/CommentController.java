package com.frank.diandi.controller;

import com.frank.diandi.common.Result;
import com.frank.diandi.dto.CommentDTO;
import com.frank.diandi.entity.User;
import com.frank.diandi.service.CommentService;
import com.frank.diandi.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author frank
 * @date 2023/11/15
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private UserService userService;

    @RequestMapping("/create")
    public Result<Boolean> createComment(@RequestBody CommentDTO commentDTO, @RequestHeader(value = "token", required = false) String token) {
        User user = userService.getUserByToken(token);
        return commentService.createComment(commentDTO, user.getId());
    }


    @RequestMapping("/update")
    public Result<Boolean> updateComment(@RequestBody CommentDTO commentDTO, @RequestHeader(value = "token", required = false) String token) {
        User user = userService.getUserByToken(token);
        return commentService.updateComment(commentDTO, user.getId());
    }

    @RequestMapping("delete")
    public Result<Boolean> deleteComment(@RequestBody CommentDTO commentDTO, @RequestHeader(value = "token", required = false) String token) {
        User user = userService.getUserByToken(token);
        boolean remove = commentService.removeById(commentDTO.getCommentId());
        if (remove) {
            return Result.success("remove comment success.", true);
        }
        return Result.failed("remove comment failed", false);
    }

}
