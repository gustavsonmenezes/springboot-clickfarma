package com.clickfarma.repositories;

import com.clickfarma.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos customizados podem ser adicionados aqui
    // Exemplo: List<Produto> findByCategoria(String categoria);
}