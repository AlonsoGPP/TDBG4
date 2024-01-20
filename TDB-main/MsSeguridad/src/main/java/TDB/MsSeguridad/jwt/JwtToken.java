package TDB.MsSeguridad.jwt;

import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import TDB.MsSeguridad.dtos.UserRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {
    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;
     
     @Value("${jwt.secret}")
     private String secret ;    
     
     public String generateToken(UserRequest authRequest) {
 
            Key hmacKey = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Instant now = Instant.now();
            String jwtToken = Jwts.builder()
                    .claim("usuario", authRequest.getUsername())
                //     .claim("pass", authRequest.getPassword())
                    .setSubject(authRequest.getUsername())
                    .setId(UUID.randomUUID().toString())
                    .setIssuedAt(Date.from(now))
                    .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                    .signWith(hmacKey)
                    .compact();
           
            return jwtToken;
        } 
}
