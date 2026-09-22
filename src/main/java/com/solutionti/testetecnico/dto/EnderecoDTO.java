package com.solutionti.testetecnico.dto;

import java.time.LocalDate;

public record EnderecoDTO(
         Long id,
         Long userId,
         String cep,
         String logradouro,
         String numero,
         String bairro,
         String cidade,
         String estado,
         String complemento,
         LocalDate createdAt,
         Boolean isMain

) {}
