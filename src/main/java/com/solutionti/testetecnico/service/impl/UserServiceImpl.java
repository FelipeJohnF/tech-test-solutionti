package com.solutionti.testetecnico.service.impl;

import com.solutionti.testetecnico.dto.UserDTO;
import com.solutionti.testetecnico.entity.User;
import com.solutionti.testetecnico.exception.ResourceNotFoundException;
import com.solutionti.testetecnico.repository.UserRepository;
import com.solutionti.testetecnico.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;// REMOVER

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setNome(userDTO.nome());
        user.setCpf(userDTO.cpf());
        user.setSenha(passwordEncoder.encode(userDTO.senha()));
        user.setDataNascimento(userDTO.dataNascimento());
        user.setRole(userDTO.role().toUpperCase());

        User saved = userRepository.save(user);

        return mapToDTO(saved);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public UserDTO getUserByCpf(String cpf){

        User user = userRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado por CPF"));

        return mapToDTO(user);

    }

    @Override
    public String deleteUser(Long id) {
        return "";
    }

    private UserDTO mapToDTO(User user) {

        return new UserDTO(user.getId(),
                        user.getNome(),
                        user.getCpf(),
                        user.getDataNascimento(),
                        user.getSenha(),
                        user.getRole(),
                        user.getCreatedAt()
                        );

    }
}
