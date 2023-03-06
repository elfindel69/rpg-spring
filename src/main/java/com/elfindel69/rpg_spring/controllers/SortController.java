package com.elfindel69.rpg_spring.controllers;

import com.elfindel69.rpg_spring.handler.EquipementHandler;
import com.elfindel69.rpg_spring.handler.SortHandler;
import com.elfindel69.rpg_spring.manager.EquipementManager;
import com.elfindel69.rpg_spring.manager.SortManager;
import com.elfindel69.rpg_spring.models.Equipement;
import com.elfindel69.rpg_spring.models.Sort;
import dto.EquipementDto;
import dto.SortDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200","http://localhost"})
@RestController
@RequestMapping(path ="/sorts")
@AllArgsConstructor
public class SortController {
    private final SortManager manager;

    @GetMapping("/all")
    List<Sort> getAllEquipements(){
        return manager.getSorts();
    }

    @GetMapping("/{id}")
    Sort getEquipementById(@PathVariable Long id){
        return manager.getSort(id);
    }

    @PostMapping("/")
    Sort createEquipement(@RequestBody SortDto dto){
        return manager.createSort(new SortHandler(dto));

    }
}
