package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SkillLevel {

    NONEXISTENT(0, "non-existent"),
    DISASTROUS(1, "disastrous"),
    WRETCHED(2, "wretched"),
    POOR(3, "poor"),
    WEAK(4, "weak"),
    INADEQUATE(5, "inadequate"),
    PASSABLE(6, "passable"),
    SOLID(7, "solid"),
    EXCELLENT(8, "excellent"),
    FORMIDABLE(9, "formidable"),
    OUTSTANDING(10, "outstanding"),
    BRILLIANT(11, "brilliant"),
    MAGNIFICENT(12, "magnificent"),
    WORLDCLASS(13, "world class"),
    SUPERNATURAL(14, "supernatural"),
    TITANIC(15, "titanic"),
    EXTRATERRESTRIAL(16, "extra-terrestrial"),
    MYTHICAL(17, "mythical"),
    MAGICAL(18, "magical"),
    UTOPIAN(19, "utopian"),
    DIVINE(20, "divine");

    protected Integer value;
    protected String description;

    SkillLevel(Integer code, String description) {
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
    public static SkillLevel parse(Integer id) {
        SkillLevel skillLevel = null; // Default
        for (SkillLevel item : SkillLevel.values()) {
            if (item.getValue().equals(id)) {
                skillLevel = item;
                break;
            }
        }
        return skillLevel;
    }

    public static Map asMap() {
        SkillLevel[] values = SkillLevel.values();
        Map<Integer, String> result = new HashMap();
        for (SkillLevel value1 : values) {
            result.put(value1.getValue(), value1.getDescription());
        }

        return result;
    }
}
