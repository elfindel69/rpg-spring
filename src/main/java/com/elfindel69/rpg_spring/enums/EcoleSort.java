package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EcoleSort {
    AIR("Air"),
    FEU("Feu"),
    TERRE("Terre"),
    EAU("Eau"),
    NATURE("Nature"),
    ENERGIE("Energie"),
    VIE("Vie"),
    MORT("Mort");

    private final String name;

    public static EcoleSort fromName(final String name) {
        for (EcoleSort es : EcoleSort.values()) {
            if (es.name.equals(name)) {
                return es;
            }
        }
        return null;
    }

}
