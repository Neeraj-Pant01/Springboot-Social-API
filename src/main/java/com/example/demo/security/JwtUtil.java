package com.example.demo.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "TH&IS%$IST&@HE$E*R(E)@T7JW$T#S@C4";
    private final long EXPIRATION_TIME = 86400000;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.ES256, SECRET_KEY)
                .compact();
    }

    public String extractuserName(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
