package com.elfindel69.rpg_spring.controllers;

import com.elfindel69.rpg_spring.handler.PersonnageHandler;
import com.elfindel69.rpg_spring.manager.PersonnageManager;
import com.elfindel69.rpg_spring.models.Personnage;
import dto.PersonnageDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200","http://localhost"})
@RestController
@RequestMapping(path ="/personnage")
@AllArgsConstructor
public class PersonnageController {

    private final PersonnageManager manager;
    @GetMapping("/all")
    List<Personnage> getAllPersonnages(){
        return manager.getPersonnages();
    }

    @GetMapping("/{id}")
    Personnage getPersonnageById(@PathVariable Long id){
        return manager.getPersonnage(id);
    }

    @PostMapping("/")
    Personnage createPersonnage(@RequestBody PersonnageDto dto){
        return manager.createPersonnage(new PersonnageHandler(dto));
    }


}
