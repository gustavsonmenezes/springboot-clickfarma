package com.clickfarma.clickfarma_backend.dto;

import lombok.Data;

@Data
public class LoginRequest {
    public String email;
    public String password;
}
