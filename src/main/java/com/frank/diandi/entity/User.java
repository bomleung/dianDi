package com.frank.diandi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author frank
 * @date 2023/11/13
 **/
@Data
@NoArgsConstructor
public class User {

    private Long id;

    private String userName;

    private String password;

    private String salt;

    private String createBy;

    private String updateBy;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
