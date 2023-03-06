package com.elfindel69.rpg_spring.controllers;

import com.elfindel69.rpg_spring.handler.EquipementHandler;
import com.elfindel69.rpg_spring.manager.EquipementManager;
import com.elfindel69.rpg_spring.models.Equipement;
import com.elfindel69.rpg_spring.models.Personnage;
import dto.EquipementDto;
import dto.PersonnageDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200","http://localhost"})
@RestController
@RequestMapping(path ="/equipement")
@AllArgsConstructor
public class EquipemementController {

    private final EquipementManager manager;

    @GetMapping("/all")
    List<Equipement> getAllEquipements(){
        return manager.getEquipements();
    }

    @GetMapping("/{id}")
    Equipement getEquipementById(@PathVariable Long id){
        return manager.getEquipement(id);
    }

    @PostMapping("/")
    Equipement createEquipement(@RequestBody EquipementDto dto){
        return manager.createEquipement(new EquipementHandler(dto));

    }
}