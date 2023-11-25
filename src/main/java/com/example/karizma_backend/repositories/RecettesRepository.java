package com.example.karizma_backend.repositories;

import com.example.karizma_backend.entities.Recettes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecettesRepository extends JpaRepository<Recettes,Long> {
}
