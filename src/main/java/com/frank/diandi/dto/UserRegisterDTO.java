package com.frank.diandi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    private String userName;

    private String password;
}
