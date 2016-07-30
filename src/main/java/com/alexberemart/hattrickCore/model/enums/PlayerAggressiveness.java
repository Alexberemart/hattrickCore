package com.alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum PlayerAggressiveness {

    UNSTABLE(5, "Unstable"),
    FIERY(4, "Fiery"),
    TEMPERAMENTAL(3, "Temperamental"),
    BALANCED(2, "Balanced"),
    CALM(1, "Calm"),
    TRANQUIL(0, "Tranquil");

    protected Integer value;
    protected String description;

    PlayerAggressiveness(Integer code, String description) {
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
    public static PlayerAggressiveness parse(Integer id) {
        PlayerAggressiveness playerAggressiveness = null; // Default
        for (PlayerAggressiveness item : PlayerAggressiveness.values()) {
            if (item.getValue().equals(id)) {
                playerAggressiveness = item;
                break;
            }
        }
        return playerAggressiveness;
    }

    public static Map asMap() {
        PlayerAggressiveness[] values = PlayerAggressiveness.values();
        Map<Integer, String> result = new HashMap();
        for (PlayerAggressiveness value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
