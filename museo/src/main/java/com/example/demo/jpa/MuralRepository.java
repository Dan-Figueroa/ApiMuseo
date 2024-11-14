package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Artista;
import com.example.demo.entity.Mural;

import java.util.List;


public interface MuralRepository extends JpaRepository<Mural, Long> {
    List<Mural> findByArtista(Artista artista); // Asegúrate de que el método esté definido
}


