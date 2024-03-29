package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Portee {
    FAIBLE("Faible"),
    MOYENNE("Moyenne"),
    ELOIGNEE("Eloignee");

    private final String name;

    public static Portee fromName(final String name) {
        for (Portee p : Portee.values()) {
            if (p.name.equals(name)) {
                return p;
            }
        }
        return null;
    }
}
