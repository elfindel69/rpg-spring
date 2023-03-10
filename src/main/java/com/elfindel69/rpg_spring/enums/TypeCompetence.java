package com.elfindel69.rpg_spring.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypeCompetence {

    HABILETE("Habilete"),
    SPECIALISATION("Specialisation");

    private final String name;

    public static TypeCompetence findByName(String name){
        for (TypeCompetence tc: TypeCompetence.values()) {
            if(tc.name.equals(name)){
                return tc;
            }
        }
        return null;
    }
}
