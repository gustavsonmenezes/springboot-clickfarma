package com.clickfarma.clickfarma_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marca a classe como uma entidade JPA (tabela no DB)
@Table(name = "users") // Define o nome da tabela
@Data // Gera getters, setters, toString, equals e hashCode (do Lombok)
@NoArgsConstructor // Gera construtor sem argumentos (do Lombok)
@AllArgsConstructor // Gera construtor com todos os argumentos (do Lombok)
public class User {

    @Id // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do ID
    private Long id;

    @Column(unique = true, nullable = false) // Garante que o email seja único e obrigatório
    private String email;

    @Column(nullable = false)
    private String password; // A senha será armazenada criptografada

    @Column(nullable = false)
    private String name;
}
