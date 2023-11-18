package com.frank.diandi.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String secret;

    private JwtHeader header;

    private JwtPayload payload;
}
