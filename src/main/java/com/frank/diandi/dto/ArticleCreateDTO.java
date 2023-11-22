package com.frank.diandi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frank
 * @date 2023/11/22
 **/
@Data
@NoArgsConstructor
public class ArticleCreateDTO {

    private Long userId;

    private String text;

    private String title;
}
