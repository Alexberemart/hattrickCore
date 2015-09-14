package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum MatchStatus {

    UPCOMING(0, "Upcoming"),
    ONGOING(1, "Ongoing"),
    FINISHED(2, "Finished");

    protected Integer value;
    protected String description;

    MatchStatus(Integer code, String description) {
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
    public static MatchStatus parse(Integer id) {
        MatchStatus matchStatus = null; // Default
        for (MatchStatus item : MatchStatus.values()) {
            if (item.getValue().equals(id)) {
                matchStatus = item;
                break;
            }
        }
        return matchStatus;
    }

    public static Map asMap() {
        MatchStatus[] values = MatchStatus.values();
        Map<Integer, String> result = new HashMap();
        for (int i = 0; i < values.length; i++) {
            result.put(values[i].getValue(), values[i].getDescription());
        }

        return result;
    }
}
