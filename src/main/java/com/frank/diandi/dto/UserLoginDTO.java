package com.frank.diandi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Data
@NoArgsConstructor
public class UserLoginDTO {

    private String userName;

    private String password;

    private String salt;

}
