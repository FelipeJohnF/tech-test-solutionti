package com.solutionti.testetecnico.service.impl;

import com.solutionti.testetecnico.dto.EnderecoDTO;
import com.solutionti.testetecnico.entity.Endereco;
import com.solutionti.testetecnico.entity.User;
import com.solutionti.testetecnico.exception.ResourceNotFoundException;
import com.solutionti.testetecnico.repository.EnderecoRepository;
import com.solutionti.testetecnico.repository.UserRepository;
import com.solutionti.testetecnico.service.EnderecoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final UserRepository userRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, UserRepository userRepository){

        this.enderecoRepository = enderecoRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public EnderecoDTO createEndereco(EnderecoDTO enderecoDTO){

        User user = userRepository.findById(enderecoDTO.userId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + enderecoDTO.userId()));

        Endereco endereco = new Endereco();
        endereco.setCep(enderecoDTO.cep());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setEstado(enderecoDTO.estado());
        endereco.setComplemento(enderecoDTO.complemento());
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setMain(endereco.isMain());
        endereco.setUser(user);


        Endereco saved = enderecoRepository.save(endereco);

        return  mapToDTO(saved);
    }

    @Override
    public List<EnderecoDTO> getAllEnderecos() {
        return enderecoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<EnderecoDTO> getEnderecosByUserId(Long userId) {
        return enderecoRepository.findUserEndereco(userId)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    @Transactional
    public void deleteEndereco(Long id){

        if(!enderecoRepository.existsById(id)){
            throw new ResourceNotFoundException("Endereço não encontrado com o ID: " + id);
        }

        enderecoRepository.deleteById(id);
    }

    private EnderecoDTO mapToDTO(Endereco endereco){

        return new EnderecoDTO(
                endereco.getId(),
                endereco.getUser().getId(),
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getComplemento(),
                endereco.getCreatedAt(),
                endereco.isMain()
                );
    }
}
