package com.elfindel69.rpg_spring.manager.impl;

import com.elfindel69.rpg_spring.enums.TypeEquipement;
import com.elfindel69.rpg_spring.handler.EquipementHandler;
import com.elfindel69.rpg_spring.manager.EquipementManager;
import com.elfindel69.rpg_spring.models.Arme;
import com.elfindel69.rpg_spring.models.Equipement;
import com.elfindel69.rpg_spring.models.PotionVie;
import com.elfindel69.rpg_spring.models.Protection;
import com.elfindel69.rpg_spring.services.EquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipementManagerImpl implements EquipementManager {

    private final EquipementService service;
    @Override
    public Equipement createEquipement(EquipementHandler handler) {
       Equipement equip = null;
        if (handler.getType().equals(TypeEquipement.ARMEMENT)){
            equip = new Arme(handler.getNom(),handler.getPrix(),handler.getDe(),handler.getModif());
        }
        if (handler.getType().equals(TypeEquipement.PROTECTION))
        {
            equip = new Protection(handler.getNom(),handler.getPrix(),handler.getArmure());
        }
        if (handler.getType().equals(TypeEquipement.POTION)){
            if (handler.getPv() > 0){
                equip = new PotionVie(handler.getNom(),handler.getPrix(),handler.getPv());
            }
            if(handler.getMana() > 0){
                equip = new PotionVie(handler.getNom(),handler.getPrix(),handler.getMana());
            }
        }
        return service.createEquipement(equip);
    }

    @Override
    public Equipement getEquipement(long id) {
        return service.getEquipement(id);
    }

    @Override
    public List<Equipement> getEquipements() {
        return service.getEquipements();
    }

    @Override
    public void deleteEquipement(long id) {
        service.deleteEquipement(id);
    }
}
