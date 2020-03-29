package com.pelican.api.auth.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.Key;

@ConfigurationProperties(prefix = "application.jwt")
@Component
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Integer tokenLifetimeInDays;

    public JwtConfig() {
    }

    public Key getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public Integer getTokenLifetimeInDays() {
        return tokenLifetimeInDays;
    }

    public String getAuthorizationHeader(){
        return "Authorization";
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public void setTokenLifetimeInDays(Integer tokenLifetimeInDays) {
        this.tokenLifetimeInDays = tokenLifetimeInDays;
    }
}
