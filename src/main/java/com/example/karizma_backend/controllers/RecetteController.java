package com.example.karizma_backend.controllers;

import com.example.karizma_backend.entities.Recettes;
import com.example.karizma_backend.service.impl.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping
    public List<Recettes> getAllRecettes() {
        return recetteService.getAllRecettes();
    }

    @GetMapping("/{id}")
    public Recettes getRecetteById(@PathVariable Long id) {
        return recetteService.getRecetteById(id);
    }

    @PostMapping
    public Recettes createRecette(@RequestBody Recettes recette) {
        return recetteService.createRecette(recette);
    }

    @PutMapping("/{id}")
    public Recettes updateRecette(@PathVariable Long id, @RequestBody Recettes recette) {
        return recetteService.updateRecette(id, recette);
    }

    @DeleteMapping("/{id}")
    public void deleteRecette(@PathVariable Long id) {
        recetteService.deleteRecette(id);
    }
}
