package com.example.karizma_backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingredient;
    private String nom;
    private double quantite;
    private String unite;

    @ManyToOne
    @JoinColumn(name = "id_recette")
    private Recettes recette;
}
