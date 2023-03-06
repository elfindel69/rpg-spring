package com.elfindel69.rpg_spring.services.impl;

import com.elfindel69.rpg_spring.models.Equipement;
import com.elfindel69.rpg_spring.repository.EquipementRepository;
import com.elfindel69.rpg_spring.services.EquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements EquipementService {
    private final EquipementRepository repository;

    @Override
    public Equipement createEquipement(Equipement equipement) {
        return repository.save(equipement);
    }

    @Override
    public Equipement getEquipement(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> getEquipements() {
        return repository.findAll();
    }

    @Override
    public void deleteEquipement(long id) {
        repository.deleteById(id);
    }
}
