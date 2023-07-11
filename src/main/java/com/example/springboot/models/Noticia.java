package com.example.springboot.models;

import com.example.springboot.DTOs.NoticiaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String descricao;
    private String link;

    private boolean processado;
    public Noticia(NoticiaDTO dto){
        this(null, dto.titulo(), dto.descricao(), dto.link(), false);
    }
}
