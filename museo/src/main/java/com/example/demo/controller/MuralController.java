package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Mural;
import com.example.demo.jpa.ArtistaRepository;
import com.example.demo.jpa.MuralRepository;
import java.util.List;

@RestController
@RequestMapping("/api/murales")
public class MuralController {

    @Autowired
    private MuralRepository muralRepository;

    @Autowired
    private ArtistaRepository artistaRepository; // Agrega el repositorio de Artista

    // Obtener todos los murales
    @GetMapping
    public ResponseEntity<List<Mural>> getAllMurales() {
        List<Mural> murales = muralRepository.findAll();
        return ResponseEntity.ok(murales);
    }

    // Crear un nuevo mural
    @PostMapping
    public ResponseEntity<Mural> createMural(@RequestBody Mural mural) {
        Mural nuevoMural = muralRepository.save(mural);
        return ResponseEntity.status(201).body(nuevoMural);
    }

    // Obtener un mural por su ID
    @GetMapping("/{idM}")
    public ResponseEntity<Mural> getMuralById(@PathVariable Long idM) {
        return muralRepository.findById(idM)
                .map(mural -> ResponseEntity.ok(mural))
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener murales por artista
    @GetMapping("/artista/{artistaId}")
    public ResponseEntity<List<Mural>> getMuralesByArtista(@PathVariable Long artistaId) {
        return artistaRepository.findById(artistaId)
                .map(artista -> {
                    List<Mural> murales = muralRepository.findByArtista(artista);
                    return ResponseEntity.ok(murales);
                })
                .orElse(ResponseEntity.notFound().build()); // Si el artista no existe, retorna 404
    }

    // Actualizar un mural
    @PutMapping("/{idM}")
    public ResponseEntity<Mural> updateMural(@PathVariable Long idM, @RequestBody Mural mural) {
        if (!muralRepository.existsById(idM)) {
            return ResponseEntity.notFound().build();
        }
        mural.setIdM(idM);
        Mural updatedMural = muralRepository.save(mural);
        return ResponseEntity.ok(updatedMural);
    }

    // Eliminar un mural
    @DeleteMapping("/{idM}")
    public ResponseEntity<Void> deleteMural(@PathVariable Long idM) {
        if (!muralRepository.existsById(idM)) {
            return ResponseEntity.notFound().build();
        }
        muralRepository.deleteById(idM);
        return ResponseEntity.noContent().build();
    }
}
