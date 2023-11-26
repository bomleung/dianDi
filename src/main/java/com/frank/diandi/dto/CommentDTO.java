package com.frank.diandi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frank
 * @date 2023/11/26
 **/
@Data
@NoArgsConstructor
public class CommentDTO {

    private Long commentId;

    private Long articleId;

    private String content;
}
