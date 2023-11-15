package com.frank.diandi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author frank
 * @date 2023/11/14
 **/

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Article {

    private Long id;

    private Long userId;

    private String text;

    private String title;

    private String createBy;

    private String updateBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
