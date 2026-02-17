package com.startcoding0to1.springboot_jwt_auth.util;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JWTUtil {

    /*
    *   public static void main(String[] args) {
            String key = "my-super-secret-key-that-is-very-long";
            String encoded = Base64.getEncoder().encodeToString(key.getBytes());
            System.out.println(encoded); //bXktc3VwZXItc2VjcmV0LWtleS10aGF0LWlzLXZlcnktbG9uZw==
        }
    * */
    @Value("${jwt.secret:bXktc3VwZXItc2VjcmV0LWtleS10aGF0LWlzLXZlcnktbG9uZw==}")
    private String SECRET_KEY;
    private Key key;

    public String generateToken(String username, long expiration) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration*60*1000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    @PostConstruct
    public void init() {
        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
        key = Keys.hmacShaKeyFor(decodedKey);
    }

    public String validateAndExtractUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }  catch (ExpiredJwtException e) {
            return null;
        }
    }

}
