package com.micro.gateway.controller;

import com.micro.gateway.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @GetMapping("/token")
    public String generateToken(@RequestParam String username) {

        return jwtUtil.generateToken(username);

    }

}