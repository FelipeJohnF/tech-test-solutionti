package com.solutionti.testetecnico.dto;

import java.time.Instant;
import java.time.LocalDate;

public record UserDTO (
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String senha,
        String role,
        Instant createdAt

){}