package com.elfindel69.rpg_spring.manager;

import com.elfindel69.rpg_spring.handler.EquipementHandler;
import com.elfindel69.rpg_spring.models.Equipement;

import java.util.List;

public interface EquipementManager {

    Equipement createEquipement(EquipementHandler handler);

    Equipement getEquipement(long id);

    List<Equipement> getEquipements();

    void deleteEquipement(long id);
}
