package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SourceSystem {

    HATTRICK("hattrick", "Hattrick main system"),
    YOUTH("youth", "Youth system"),
    HTOINTEGRATED("htointegrated", "Hattrick integrated used for ex turnaments");

    protected String value;
    protected String description;

    SourceSystem(String code, String description) {
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
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public static SourceSystem parse(String id) {
        SourceSystem sourceSystem = null; // Default
        for (SourceSystem item : SourceSystem.values()) {
            if (item.getValue().equals(id)) {
                sourceSystem = item;
                break;
            }
        }
        return sourceSystem;
    }

    public static Map asMap() {
        SourceSystem[] values = SourceSystem.values();
        Map<String, String> result = new HashMap();
        for (SourceSystem value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
