package com.clickfarma.clickfarma_backend.repository;

import com.clickfarma.clickfarma_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// JpaRepository<Tipo da Entidade, Tipo da Chave Primária>
public interface UserRepository extends JpaRepository<User, Long> {

    // O Spring Data JPA gera a query SQL automaticamente a partir do nome do método
    Optional<User> findByEmail(String email);
}
