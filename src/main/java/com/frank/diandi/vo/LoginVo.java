package com.frank.diandi.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frank
 * @date 2023/11/20
 **/
@Data
@NoArgsConstructor
public class LoginVo {
    private String userName;

    private String token;
}
