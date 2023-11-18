package com.frank.diandi.config.jwt;

import lombok.Data;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Data
public class JwtPayload {

    private RegisterClaims registerClaims;
}
