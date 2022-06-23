package com.bkap.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bkap.entitysecurity.UserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTUtils {
	// key đăng ký cho token
		private static String SECRET = "dam van luan";
		
		private final long Expiration_time = 604800000L;
		
		public String generationToken(UserDetail userDetail) {
			
			Date date = new Date();
			
			Date expiryDate = new Date(date.getTime()+ Expiration_time);
			
			String jwt = "";
			
			try {
				jwt = Jwts.builder()
						.setSubject(Integer.toString(userDetail.getUsers().getId()))
						.setIssuedAt(date)
						.setExpiration(expiryDate)
						.signWith(SignatureAlgorithm.HS512, SECRET.getBytes("UTF-8"))
						.compact();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jwt;
			
		}
		
		// tạo thêm phương thức lấy id user thông qua subject
		
		public Integer getIdUsersFromToken(String authToken) {
			Claims claims = null;
			try {
				claims = Jwts.parser().setSigningKey(SECRET.getBytes("UTF-8")).parseClaimsJws(authToken).getBody();
			} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
					| IllegalArgumentException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Integer.parseInt(claims.getSubject());
		}
		
	// tạo thêm phương thức lấy Email user thông qua subject
		
		public String getEmailUsersFromToken(String authToken) {
			Claims claims = null;
			try {
				claims = Jwts.parser().setSigningKey(SECRET.getBytes("UTF-8")).parseClaimsJws(authToken).getBody();
			} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
					| IllegalArgumentException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return claims.getSubject();
		}
		
		
		// validate token 
		public boolean validateToken(String authToken) {
			// các bạn chú ý ở đây có jwt và jws . Jwt hình như ko được hỗ trợ cho spring boot
			try {
				Jwts.parser().setSigningKey(SECRET.getBytes("UTF-8")).parseClaimsJws(authToken);
				return true;
			} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
					| IllegalArgumentException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
}
