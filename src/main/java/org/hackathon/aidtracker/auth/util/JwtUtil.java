package org.hackathon.aidtracker.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil {
    private static byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SysConstant.JWT_SECRET_KEY);
    private static SecretKey secretKey = Keys.hmacShaKeyFor(apiKeySecretBytes);
    public static String createToken (String username, List<String> auth){
        long expiration = SysConstant.EXPIRATION_REMEMBER ;

        String tokenPrefix = Jwts.builder()
                .setHeaderParam("typ", SysConstant.TOKEN_TYPE)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .claim(SysConstant.TOKEN_CLAIMS, String.join(",", auth))
                .setIssuer("aid-tracker")
                .setIssuedAt(new Date())
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
        return SysConstant.TOKEN_PREFIX + tokenPrefix;
    }
    public static String getUsernameByToken(String token) {
        return getTokenBody(token).getSubject();
    }


    public static List<SimpleGrantedAuthority> getUserRolesByToken(String token) {
        String role = (String) getTokenBody(token)
                .get(SysConstant.TOKEN_CLAIMS);
        return Arrays.stream(role.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private static Claims getTokenBody(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }
}
