package com.elfindel69.rpg_spring.controllers;

import com.elfindel69.rpg_spring.dto.PersonnageDto;
import com.elfindel69.rpg_spring.handler.PersonnageHandler;
import com.elfindel69.rpg_spring.manager.PersonnageManager;
import com.elfindel69.rpg_spring.models.Personnage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping(path = "/personnages")
@AllArgsConstructor
public class PersonnageController {

    private final PersonnageManager manager;

    @GetMapping("/all")
    List<Personnage> getAllPersonnages() {
        return manager.getPersonnages();
    }

    @GetMapping("/{id}")
    Personnage getPersonnageById(@PathVariable Long id) {
        return manager.getPersonnage(id);
    }

    @PostMapping("/create")
    Personnage createPersonnage(@RequestBody PersonnageDto dto) {
        return manager.createPersonnage(new PersonnageHandler(dto));
    }

    //PUT /personnages/:id add Equipement   (id du personnage, id de l'équipement)
    @PutMapping("/{id}/addEquip/{idEquipement}")
    Personnage addEquipement(@PathVariable Long id, @PathVariable Long idEquipement) {
        return manager.addEquipement(id, idEquipement);
    }

    @PutMapping("/{id}/addSort/{idSort}")
    Personnage addSort(@PathVariable Long id, @PathVariable Long idSort) {
        return manager.addSort(id, idSort);
    }

    @PutMapping("/{id}/addComp/{idComp}")
    Personnage addComp(@PathVariable Long id, @PathVariable Long idComp) {
        return manager.addComp(id, idComp);
    }
}
