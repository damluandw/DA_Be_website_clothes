package com.bkap.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.bkap.services.UserDetailService;
import com.bkap.util.JWTUtils;

public class JWTFilter extends OncePerRequestFilter {
	@Autowired
	private UserDetailService userService;

	@Autowired
	private JWTUtils jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			// Lấy jwt từ request
			String jwt = getJwtFromRequest(request);

			if (StringUtils.hasText(jwt) && jwtUtil.validateToken(jwt)) {

				// lấy id user
				Integer userId = jwtUtil.getIdUsersFromToken(jwt);

				UserDetails user = userService.loadUserById(userId);

				if (user != null) {

					// Nếu người dùng hợp lệ, set thông tin cho Security Context
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
							null, user.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		filterChain.doFilter(request, response);

	}

	private String getJwtFromRequest(HttpServletRequest request) {

		String bearToken = request.getHeader("Authorization");

		if (StringUtils.hasText(bearToken) && bearToken.startsWith("Bearer ")) {
			return bearToken.substring(7);
		}
		return null;
	}
}
