package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Archetype {

    ROGUE("Rogue"),
    GUERRIER("Guerrier"),
    MAGICIEN("Magicien");

    private final String name;

    public static Archetype fromName(String name) {
        for (Archetype a : Archetype.values()) {
            if (a.name.equals(name)) {
                return a;
            }
        }
        return null;
    }
}
