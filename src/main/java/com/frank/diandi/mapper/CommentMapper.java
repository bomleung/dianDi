package com.frank.diandi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.diandi.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author frank
 * @date 2023/11/14
 **/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
