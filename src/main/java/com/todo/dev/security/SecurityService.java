package com.todo.dev.security;


import com.todo.dev.domain.dto.Members;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityService {
    @Value("${jwt.SECRET_KEY}")
    private String SECRET_KEY;
    @Value("${jwt.EXP_TIME}")
    private String EXP_TIME;

    public String createToken(Members members){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
        byte[] secretKeyByte = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key key = new SecretKeySpec(secretKeyByte, signatureAlgorithm.getJcaName());
        Map<String,Object> map = new HashMap<>();
        map.put("id", members.getId());
        map.put("name", members.getName());
        map.put("phoneNumber", members.getPhone_number());
        return Jwts.builder()
                .setClaims(map)
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(EXP_TIME)))
                .compact();
    }
    public TokenInfo parseToken(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
        TokenInfo info = new TokenInfo().parseToken(claims);
        return info;

    }
}
