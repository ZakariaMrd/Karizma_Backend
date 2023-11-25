package com.example.karizma_backend.service;


import com.example.karizma_backend.dtos.request.SignUpRequest;
import com.example.karizma_backend.dtos.request.SigninRequest;
import com.example.karizma_backend.dtos.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
