package com.clickfarma.clickfarma_backend.controller;

import com.clickfarma.clickfarma_backend.model.User;
import com.clickfarma.clickfarma_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


class RegisterRequest {
    public String name;
    public String email;
    public String password;
}

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        try {
            User registeredUser = authService.registerUser(request.name, request.email, request.password);
            // Retorna o usuário criado com status 201 (Created)
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Retorna um erro se o email já estiver cadastrado
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
