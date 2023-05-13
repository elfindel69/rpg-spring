package com.elfindel69.rpg_spring.controllers;

import com.elfindel69.rpg_spring.dto.CompetenceDto;
import com.elfindel69.rpg_spring.handler.CompetenceHandler;
import com.elfindel69.rpg_spring.manager.CompetenceManager;
import com.elfindel69.rpg_spring.models.Competence;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping(path = "/competence")
@AllArgsConstructor
public class CompetenceController {
    private final CompetenceManager manager;

    @GetMapping("/all")
    List<Competence> getAllCompetences() {
        return manager.getCompetences();
    }

    @GetMapping("/{id}")
    Competence getCompetenceById(@PathVariable Long id) {
        return manager.getCompetence(id);
    }

    @PostMapping("/create")
    Competence createCompetence(@RequestBody CompetenceDto dto) {
        return manager.createCompetence(new CompetenceHandler(dto));

    }

}
