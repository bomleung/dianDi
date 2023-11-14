package com.frank.diandi.entity;

import java.time.LocalDateTime;

/**
 * @author frank
 * @date 2023/11/14
 **/
public class Article {

    private Long id;

    private Long userId;

    private String comment;

    private String title;

    private String createBy;

    private String updateBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
