package lk.ijse.gdse.spring_security_backend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.expriration}")
    private String expriration;

    @Value("{jwt.secretKey}")
    private String secretKey;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(String.valueOf(new Date()))
                .setExpiration(new Date(
                        System.currentTimeMillis() + expriration
                ))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes())
                , SignatureAlgorithm.HS256).compact();

    }

    public boolean extractUsername(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                            .build()
                            .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true; // Placeholder for actual validation logic
        }catch (Exception e) {
            return false; // If token is invalid or expired, return false
        }
    }


}
