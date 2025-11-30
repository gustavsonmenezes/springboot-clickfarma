package com.clickfarma.clickfarma_backend.service;

import com.clickfarma.clickfarma_backend.model.User;
import com.clickfarma.clickfarma_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // Marca a classe como um componente de serviço do Spring
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Será configurado na Fase 4

    public User registerUser(String name, String email, String password) {
        // 1. Verificar se o usuário já existe
        if (userRepository.findByEmail(email).isPresent()) {
            // Em um projeto real, você lançaria uma exceção específica
            throw new RuntimeException("Email já cadastrado.");
        }

        // 2. Criar e salvar o novo usuário
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        // Criptografa a senha antes de salvar
        newUser.setPassword(passwordEncoder.encode(password));

        return userRepository.save(newUser);
    }

    // Método para ser usado pelo Spring Security (será melhor detalhado na Fase 4)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }
}
