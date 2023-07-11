package com.example.springboot.repository;

import com.example.springboot.models.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Long> {

    List<Noticia> findByProcessado(boolean processado);

}
