package com.alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum PlayerHonesty {

    SAINTLY(5, "Saintly"),
    RIGHTEOUS(4, "Righteous"),
    UPRIGHT(3, "Upright"),
    HONEST(2, "Honest"),
    DISHONEST(1, "Dishonest"),
    INFAMOUS(0, "Infamous");

    protected Integer value;
    protected String description;

    PlayerHonesty(Integer code, String description) {
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
    public static PlayerHonesty parse(Integer id) {
        PlayerHonesty playerHonesty = null; // Default
        for (PlayerHonesty item : PlayerHonesty.values()) {
            if (item.getValue().equals(id)) {
                playerHonesty = item;
                break;
            }
        }
        return playerHonesty;
    }

    public static Map asMap() {
        PlayerHonesty[] values = PlayerHonesty.values();
        Map<Integer, String> result = new HashMap();
        for (PlayerHonesty value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
