package com.frank.diandi.config.jwt;

import lombok.Data;

import java.io.StringReader;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Data
public class JwtHeader {

    private String alg;

    private String type;

}
