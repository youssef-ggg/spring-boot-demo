package com.example.demo.Auth;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Auth.AuthDto.AuthenticationResponse;
import com.example.demo.Auth.AuthDto.LoginDto;
import com.example.demo.Auth.AuthDto.RegisterDto;
import com.example.demo.config.JWTService;
import com.example.demo.enums.UserRoles;
import com.example.demo.model.DemoUser;
import com.example.demo.repository.DemoUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final DemoUserRepository  repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterDto user) {
        var createdUser = DemoUser.builder()
        .email(user.getEmail())
        .password(passwordEncoder.encode(user.getPassword()))
        .role(UserRoles.USER).build();
        repository.save(createdUser);

        var jwtToken = jwtService.generateToken(createdUser);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse login(LoginDto user) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
            )
        );
        var returnedUser = repository.findDemoUserByEmail(user.getEmail()).orElseThrow();
        var jwtToken  = jwtService.generateToken(returnedUser);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    

}
