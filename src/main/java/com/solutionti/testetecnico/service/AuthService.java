package com.solutionti.testetecnico.service;
 
import com.solutionti.testetecnico.dto.LoginRequestDTO;
import com.solutionti.testetecnico.dto.LoginResponseDTO;
import com.solutionti.testetecnico.dto.SignupRequestDTO;
 
public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    LoginResponseDTO signup(SignupRequestDTO signupDTO);
}