package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SelfConfidence {

    NONEXISTENT(0, "non-existent"),
    DISASTROURS(1, "disastrours"),
    WRETCHED(2, "wretched"),
    POOR(3, "poor"),
    DECENT(4, "decent"),
    STRONG(5, "strong"),
    WONDERFUL(6, "wondeful"),
    SLIGHTLY(7, "slightly exaggerated"),
    EXAGGERATED(8, "exaggerated"),
    COMPLETELY(9, "completely exaggerated");

    protected Integer value;
    protected String description;

    SelfConfidence(Integer code, String description) {
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
    public static SelfConfidence parse(Integer id) {
        SelfConfidence selfConfidence = null; // Default
        for (SelfConfidence item : SelfConfidence.values()) {
            if (item.getValue().equals(id)) {
                selfConfidence = item;
                break;
            }
        }
        return selfConfidence;
    }

    public static Map asMap() {
        SelfConfidence[] values = SelfConfidence.values();
        Map<Integer, String> result = new HashMap();
        for (SelfConfidence value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
