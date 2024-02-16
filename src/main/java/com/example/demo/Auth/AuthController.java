package com.example.demo.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Auth.AuthDto.AuthenticationResponse;
import com.example.demo.Auth.AuthDto.LoginDto;
import com.example.demo.Auth.AuthDto.RegisterDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody RegisterDto user){
        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto user){
        return ResponseEntity.ok(service.login(user));
    }
}
