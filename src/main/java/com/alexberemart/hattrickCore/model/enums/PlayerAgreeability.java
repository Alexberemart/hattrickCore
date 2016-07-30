package com.alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum PlayerAgreeability {

    BELOVED(5, "Beloved team member"),
    POPULAR(4, "Popular guy"),
    SYMPATHETIC(3, "Sympathetic guy"),
    PLEASANT(2, "Pleasant guy"),
    CONTROVERSIAL(1, "Controversial person"),
    NASTY(0, "Nasty fellow");

    protected Integer value;
    protected String description;

    PlayerAgreeability(Integer code, String description) {
        this.value = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static PlayerAgreeability parse(Integer id) {
        PlayerAgreeability playerAgreeability = null; // Default
        for (PlayerAgreeability item : PlayerAgreeability.values()) {
            if (item.getValue().equals(id)) {
                playerAgreeability = item;
                break;
            }
        }
        return playerAgreeability;
    }

    public static Map asMap() {
        PlayerAgreeability[] values = PlayerAgreeability.values();
        Map<Integer, String> result = new HashMap();
        for (PlayerAgreeability value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
