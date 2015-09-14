package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Weather {

    RAIN(0, "Rain"),
    OVERCAST(1, "Overcast"),
    PARTIALLY_CLOUDY(2, "Partially cloudy"),
    SUNNY(3, "Sunny");

    protected Integer value;
    protected String description;

    Weather(Integer code, String description) {
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
    public static Weather parse(Integer id) {
        Weather weather = null; // Default
        for (Weather item : Weather.values()) {
            if (item.getValue().equals(id)) {
                weather = item;
                break;
            }
        }
        return weather;
    }

    public static Map asMap() {
        Weather[] values = Weather.values();
        Map<Integer, String> result = new HashMap();
        for (int i = 0; i < values.length; i++) {
            result.put(values[i].getValue(), values[i].getDescription());
        }

        return result;
    }
}
