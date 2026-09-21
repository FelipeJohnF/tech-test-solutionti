package com.solutionti.testetecnico.controller;

import com.solutionti.testetecnico.dto.LoginRequestDTO;
import com.solutionti.testetecnico.dto.LoginResponseDTO;
import com.solutionti.testetecnico.dto.SignupRequestDTO;
import com.solutionti.testetecnico.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDTO> signup(@RequestBody SignupRequestDTO signupDTO) {
        return ResponseEntity.ok(authService.signup(signupDTO));
    }
}