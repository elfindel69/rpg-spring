package com.elfindel69.rpg_spring.repository;

import com.elfindel69.rpg_spring.models.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    @Override
    Optional<Equipement> findById(Long id);
}