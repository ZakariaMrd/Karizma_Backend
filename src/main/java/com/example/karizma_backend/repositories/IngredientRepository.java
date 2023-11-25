package com.example.karizma_backend.repositories;


import com.example.karizma_backend.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients,Long> {
}
