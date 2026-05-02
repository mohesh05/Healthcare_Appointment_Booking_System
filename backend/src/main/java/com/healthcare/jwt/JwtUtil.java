package com.healthcare.jwt;
import io.jsonwebtoken.*;import io.jsonwebtoken.security.Keys;import java.util.*;import javax.crypto.SecretKey;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Component;
@Component
public class JwtUtil { @Value("${app.jwt.secret}") private String secret; @Value("${app.jwt.expiration-ms}") private long exp;
 private SecretKey key(){ return Keys.hmacShaKeyFor(secret.getBytes()); }
 public String generate(String username,String role){ Date now=new Date(); return Jwts.builder().subject(username).claim("role",role).issuedAt(now).expiration(new Date(now.getTime()+exp)).signWith(key()).compact(); }
 public String username(String token){ return Jwts.parser().verifyWith(key()).build().parseSignedClaims(token).getPayload().getSubject(); }
 public boolean valid(String token){ try{ Jwts.parser().verifyWith(key()).build().parseSignedClaims(token); return true;}catch(Exception e){return false;} }
}
