package com.example.karizma_backend.repositories;

import com.example.karizma_backend.entities.EtapePreparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<EtapePreparation,Long> {
}
