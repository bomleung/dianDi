package com.frank.diandi.config.jwt;

import lombok.Data;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Data
public class RegisterClaims {

    private String iss;

    private String exp;

    private String sub;

    private String aud;
}
