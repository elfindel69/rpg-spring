package com.elfindel69.rpg_spring.repository;

import com.elfindel69.rpg_spring.models.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SortRepository extends JpaRepository<Sort, Long> {
    @Override
    Optional<Sort> findById(Long id);
}