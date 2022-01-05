package com.dragonlin.hanashopapi.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JwtCustomBean {
    @Value("${jwt.custom.key}")
    private String key;

    @Value("${jwt.custom.expired}")
    private long expired;

    public String generateJwtToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expired))
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }
    public String getSubjectFromJwtToken(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String token){
        try{
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){

        }catch (MalformedJwtException e){

        }catch (ExpiredJwtException e){

        }catch (UnsupportedJwtException e){

        }catch (IllegalArgumentException e){

        }
        return false;
    }
}