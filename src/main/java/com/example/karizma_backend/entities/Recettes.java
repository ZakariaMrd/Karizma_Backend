package com.example.karizma_backend.entities;

import com.example.karizma_backend.entities.Ingredients;
import com.example.karizma_backend.entities.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recettes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_recette;
    private String nom;

    @OneToMany(mappedBy = "recette", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ingredients> ingredients;

    @OneToMany(mappedBy = "recette", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EtapePreparation> etapesPreparation;

    private int dureePreparation; // en minutes

    @Column(nullable = true)
    private String photo; // Stocke le chemin ou l'URL de l'image (optionnel)

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
}
