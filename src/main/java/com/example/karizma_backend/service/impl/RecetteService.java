package com.example.karizma_backend.service.impl;

import com.example.karizma_backend.entities.Recettes;
import com.example.karizma_backend.repositories.RecettesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecetteService {

    @Autowired
    private RecettesRepository recetteRepository;

    public List<Recettes> getAllRecettes() {
        return recetteRepository.findAll();
    }

    public Recettes getRecetteById(Long id) {
        return recetteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recette not found with id: " + id));
    }

    public Recettes createRecette(Recettes recette) {

        return recetteRepository.save(recette);
    }

    public Recettes updateRecette(Long id, Recettes recette) {

        getRecetteById(id);


        recette.setId_recette(id);
        return recetteRepository.save(recette);
    }

    public void deleteRecette(Long id) {
        // Vérifier si la recette avec l'ID spécifié existe
        getRecetteById(id);

        // Logique de suppression de la recette
        recetteRepository.deleteById(id);
    }
}
