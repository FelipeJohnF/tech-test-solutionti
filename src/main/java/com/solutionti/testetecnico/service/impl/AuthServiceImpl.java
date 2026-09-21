package com.solutionti.testetecnico.service.impl;

import com.solutionti.testetecnico.dto.LoginRequestDTO;
import com.solutionti.testetecnico.dto.LoginResponseDTO;
import com.solutionti.testetecnico.dto.SignupRequestDTO;
import com.solutionti.testetecnico.dto.UserDTO;
import com.solutionti.testetecnico.exception.ResourceNotFoundException;
import com.solutionti.testetecnico.model.Role;
import com.solutionti.testetecnico.entity.User;
import com.solutionti.testetecnico.repository.UserRepository;
import com.solutionti.testetecnico.service.AuthService;
import com.solutionti.testetecnico.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                            JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequestDTO.getCpf(), loginRequestDTO.getSenha())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        User user = userRepository.findByCpf(loginRequestDTO.getCpf())
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        return new LoginResponseDTO(token, mapToDTO(user));
    }

    @Override
    @Transactional
    public LoginResponseDTO signup(SignupRequestDTO signupDTO) {
        User user = new User();
        user.setNome(signupDTO.getNome());
        user.setCpf(signupDTO.getCpf());
        user.setDataNascimento(signupDTO.getDataNascimento());
        user.setSenha(passwordEncoder.encode(signupDTO.getSenha()));
        user.setRole("STANDARD");

        User saved = userRepository.save(user);

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
            .username(saved.getCpf())
            .password(saved.getSenha())
            .authorities(List.of(new SimpleGrantedAuthority("ROLE_STANDARD")))
            .build();

        String token = jwtService.generateToken(userDetails);
        return new LoginResponseDTO(token, mapToDTO(saved));
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(user.getId(), user.getNome(), user.getCpf(), user.getDataNascimento(), null, user.getRole(), user.getCreatedAt());
    }
}