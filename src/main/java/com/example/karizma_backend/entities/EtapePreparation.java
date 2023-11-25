package com.example.karizma_backend.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EtapePreparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etape;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_recette")
    private Recettes recette;

}
