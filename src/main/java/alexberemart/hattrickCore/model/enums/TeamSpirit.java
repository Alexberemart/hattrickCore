package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TeamSpirit {

    COLDWAR(0, "like the Cold War"),
    MURDEROUS(1, "murderous"),
    FURIOUS(2, "furious"),
    IRRITATED(3, "irritated"),
    COMPOSED(4, "composed"),
    CALM(5, "calm"),
    CONTENT(6, "content"),
    SATISFIED(7, "satisfied"),
    DELIRIOUS(8, "delirious"),
    WALKING(9, "walking on clouds"),
    PARADISE(10, "Paradise on Earth!");

    protected Integer value;
    protected String description;

    TeamSpirit(Integer code, String description) {
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
    public static TeamSpirit parse(Integer id) {
        TeamSpirit teamSpirit = null; // Default
        for (TeamSpirit item : TeamSpirit.values()) {
            if (item.getValue().equals(id)) {
                teamSpirit = item;
                break;
            }
        }
        return teamSpirit;
    }

    public static Map asMap() {
        TeamSpirit[] values = TeamSpirit.values();
        Map<Integer, String> result = new HashMap();
        for (TeamSpirit value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
