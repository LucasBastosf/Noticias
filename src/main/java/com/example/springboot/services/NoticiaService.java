package com.example.springboot.services;

import com.example.springboot.DTOs.NoticiaDTO;
import com.example.springboot.models.Noticia;
import com.example.springboot.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository repository;
    public Noticia Salvar(NoticiaDTO dto) {
        return repository.save(new Noticia(dto));
    }
    public List<Noticia> listarnocianaoprocessada(boolean processado){
        return repository.findByProcessado(processado);
    }
    public  void update(Noticia noticia){
        repository.save(noticia);
    }
}

