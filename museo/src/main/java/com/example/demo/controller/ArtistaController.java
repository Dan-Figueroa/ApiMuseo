package com.example.demo.controller;

import com.example.demo.entity.Artista;
import com.example.demo.jpa.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Artistas")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    // Obtener todos los artistas
    @GetMapping
    public List<Artista> getAllArtistas() {
        return artistaRepository.findAll();
    }

    // Obtener un artista por ID
    @GetMapping("/{idA}")
    public Artista getArtistaById(@PathVariable Long idA) {
        return artistaRepository.findById(idA).orElse(null);
    }

    // Crear un nuevo artista
    @PostMapping
    public Artista createArtista(@RequestBody Artista artista) {
        return artistaRepository.save(artista);
    }

    // Actualizar un artista existente
    @PutMapping("/{idA}")
    public Artista updateArtista(@PathVariable Integer idA, @RequestBody Artista artista) {
        Artista.setIdA(idA);
        return artistaRepository.save(artista);
    }

    // Eliminar un artista
    @DeleteMapping("/{idA}")
    public void deleteArtista(@PathVariable Long idA) {
        artistaRepository.deleteById(idA);
    }
}
