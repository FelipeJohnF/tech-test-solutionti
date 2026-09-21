package com.solutionti.testetecnico.service.impl;

import com.solutionti.testetecnico.entity.User;
import com.solutionti.testetecnico.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDatailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDatailsService(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public  UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        User user = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o CPF: " + cpf));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getCpf())
                .password(user.getSenha())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())))
                .build();

    }

}
