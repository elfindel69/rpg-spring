package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Sexe {

    M('M'),
    F('F');

    private final char name;

    public static Sexe fromName(char name){
        for (Sexe s: Sexe.values()) {
            if (s.name == name){
                return s;
            }
        }
        return null;
    }

}
