package com.bkap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entitysecurity.UserDetail;
import com.bkap.request.LoginRequest;
import com.bkap.util.JWTUtils;

@RestController
@RequestMapping("/api")
public class LoginController {
	// vì trong config mình cung cấp cho authentication pass là encode

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JWTUtils jwtUntil;

	@GetMapping("/admin/all")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		UserDetail detail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return ResponseEntity.ok(detail.getUsers());
	}

	@PostMapping("/admin/login")
	@CrossOrigin(origins = { "*" }, allowedHeaders = "*", methods = RequestMethod.POST)
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));

		// Nếu không xảy ra exception tức là thông tin hợp lệ
		// Set thông tin authentication vào Security Context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetail detail = (UserDetail) authentication.getPrincipal();
		LoginRequest login = new LoginRequest(loginRequest.getName(), null, jwtUntil.generationToken(detail));

		return ResponseEntity.ok(login);
	}

}
