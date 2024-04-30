package com.example.CarSales.Util;

import com.example.CarSales.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtProvider {
    @Value("${security.secret-key}")
    private String secretKey;
    @Value("${security.expiration}")
    private Long expiration;
    public String generatedToken(UserDetails userDetails){
        return generatedToken(new HashMap<>(),userDetails);
    }
    public  String generatedToken(Map<String,Object>extraClaimns, UserDetails userDetails){

        return Jwts.builder()
                .setClaims(extraClaimns)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*5))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extractUsername(String token){
         return extractClaim(token, Claims::getSubject);

    }
    public boolean isValid(String token,UserDetails userDetails){
        String username = extractUsername(token);
        boolean isUsernameEquals = Objects.equals(username, userDetails.getUsername());
        boolean IsExpired = isExpired(token);
        return isUsernameEquals && !IsExpired;
    }
    public boolean isExpired(String token){
        Date expirationDate = extractExpirations(token);
        Date now = new Date();
        return expirationDate.before(now);
    }
    private Date extractExpirations(String token){

        return extractClaim(token,Claims::getExpiration);
    }
    private <T> T extractClaim(String token, Function<Claims,T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey())
                .build().parseClaimsJws(token).getBody();
    }
    private SecretKey getSignKey(){
        byte[] secretKeybyByts = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeybyByts);
    }
}
