package com.example.springboot.DTOs;

import com.example.springboot.models.Cliente;


import java.time.LocalDateTime;

public record ClienteDTO(String email, String nome, LocalDateTime nascimento){
    public ClienteDTO(Cliente cliente){
        this(cliente.getEmail(), cliente.getNome(), cliente.getNascimento());
    }
}
