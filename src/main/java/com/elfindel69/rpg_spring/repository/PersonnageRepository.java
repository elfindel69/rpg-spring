package com.elfindel69.rpg_spring.repository;

import com.elfindel69.rpg_spring.models.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnageRepository extends JpaRepository<Personnage, Long> {
    @Override
    Optional<Personnage> findById(Long id);
}