package com.solutionti.testetecnico.repository;

import com.solutionti.testetecnico.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM usuario WHERE cpf = ?1", nativeQuery = true)
    Optional<User> findByCpf(String Cpf);

    @Query(value = "SELECT * FROM usuario WHERE id = ?1", nativeQuery = true)
    List<User> findById();

}
