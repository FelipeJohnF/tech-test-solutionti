package com.solutionti.testetecnico.service;

import com.solutionti.testetecnico.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    String deleteUser(Long id);
    UserDTO getUserByCpf(String cpf);
}
