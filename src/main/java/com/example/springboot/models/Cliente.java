package com.example.springboot.models;

import com.example.springboot.DTOs.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nome;
    @Column(unique = true)
    private String email;
    private LocalDateTime nascimento;
    public Cliente(ClienteDTO dto){
        this(null, dto.nome(), dto.email(), dto.nascimento());
    }
}
