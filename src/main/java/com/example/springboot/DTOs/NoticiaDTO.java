package com.example.springboot.DTOs;

import com.example.springboot.models.Noticia;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public record NoticiaDTO(String titulo, String descricao, String link) {
    public NoticiaDTO (Noticia noticia){
        this(noticia.getTitulo(), noticia.getDescricao(), noticia.getLink());
    }
}
