package com.elfindel69.rpg_spring.services;

import com.elfindel69.rpg_spring.models.Equipement;

import java.util.List;

public interface EquipementService {
    Equipement createEquipement(Equipement equipement);

    Equipement getEquipement(long id);

    List<Equipement> getEquipements();

    void deleteEquipement(long id);
}
