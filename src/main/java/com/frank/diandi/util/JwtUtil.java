package com.frank.diandi.util;

import com.frank.diandi.config.jwt.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Date;

/**
 * @author frank
 * @date 2023/11/18
 **/
@Component
public class JwtUtil {

    @Resource
    JwtConfig jwtConfig;

    /**
     * generate key by string
     *
     * @return secret key
     */
    private SecretKey generateKey() {
        String secret = jwtConfig.getSecret();
        byte[] bytes = Base64.decodeBase64(secret);
        SecretKeySpec keySpec = new SecretKeySpec(bytes, 0, bytes.length, "AES");
        return keySpec;
    }

    /**
     * create Jwt
     *
     * @param subject
     * @return jwt String
     */
    public String createJwt(String subject) {
        long nowTime = System.currentTimeMillis();
        Date nowDate = new Date(nowTime);
        SecretKey secretKey = generateKey();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        int expireTime = 0;

        try {
            expireTime = (int) se.eval(jwtConfig.getPayload().getRegisterClaims().getExp());
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }

        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.setIssuer(jwtConfig.getPayload().getRegisterClaims().getIss());
        defaultClaims.setExpiration(new Date(System.currentTimeMillis() + expireTime));
        defaultClaims.setSubject(subject);
        defaultClaims.setAudience(jwtConfig.getPayload().getRegisterClaims().getAud());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(defaultClaims)
                .setIssuedAt(nowDate)
                .signWith(SignatureAlgorithm.forName(jwtConfig.getHeader().getAlg()), secretKey);

        return jwtBuilder.compact();
    }

    /**
     * parse jwt
     *
     * @param jwt jwt string
     * @return claims
     */
    public Claims parseJwt(String jwt) {
        SecretKey secretKey = generateKey();
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJwt(jwt).getBody();
        return claims;
    }


}
