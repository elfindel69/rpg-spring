package com.elfindel69.rpg_spring.manager;

import com.elfindel69.rpg_spring.handler.PersonnageHandler;
import com.elfindel69.rpg_spring.models.Personnage;

import java.util.List;

public interface PersonnageManager {

    Personnage createPersonnage(final PersonnageHandler handler);


    Personnage getPersonnage(long id);

    List<Personnage> getPersonnages();

    void deletePersonnage(long id);

    Personnage addEquipement(Long id, Long idEquipement);

    Personnage addSort(Long id, Long idSort);

    Personnage addComp(Long id, Long idComp);
}
