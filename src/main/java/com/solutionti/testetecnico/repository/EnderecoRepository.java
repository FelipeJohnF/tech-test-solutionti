package com.solutionti.testetecnico.repository;

import com.solutionti.testetecnico.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT * FROM endereco WHERE user_id = ?1", nativeQuery = true)
    List<Endereco> findUserEndereco(Long userId);

    @Query(value = "SELECT * FROM endereco WHERE id = ?1", nativeQuery = true)
    Endereco findEnderecosById(Long id);

}
