package com.solutionti.testetecnico.service;

import com.solutionti.testetecnico.dto.EnderecoDTO;

import java.util.List;

public interface EnderecoService {

    void deleteEndereco(Long id);
    EnderecoDTO createEndereco(EnderecoDTO enderecoDTO);
    List<EnderecoDTO> getAllEnderecos();
    List<EnderecoDTO> getEnderecosByUserId(Long userId);
    //EnderecoDTO getEnderecoById(Long id);

}
