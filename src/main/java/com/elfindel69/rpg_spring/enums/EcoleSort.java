package com.elfindel69.rpg_spring.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EcoleSort {
    AIR("AIR"),
    FEU("FEU"),
    TERRE("TERRE"),
    EAU("EAU"),
    NATURE("NATURE"),
    ENERGIE("ENERGIE"),
    VIE("VIE"),
    MORT("MORT");

    private final String name;

    public static EcoleSort fromName(final String name){
        for (EcoleSort es : EcoleSort.values()) {
            if(es.name.equals(name)){
                return es;
            }
        }
        return null;
    }

}
