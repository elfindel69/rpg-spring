package com.elfindel69.rpg_spring.repository;

import com.elfindel69.rpg_spring.models.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    @Override
    Optional<Competence> findById(Long id);
}