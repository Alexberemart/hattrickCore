package alexberemart.hattrickCore.model.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum MatchType {

    LEAGUE_MATCH(1, "League match"),
    QUALIFICATION(2, "Qualification match"),
    CUP(3, "Cup match (standard league match)"),
    FRIENDLY_NORMAL(4, "Friendly (normal rules)"),
    FRIENDLY_CUP(5, "Friendly (cup rules)"),
    RESERVED_1(6, "Not currently in use, but reserved for international competition matches with normal rules (may or may not be implemented at some future point)."),
    HT_MASTER(7, "Hattrick Masters"),
    INT_FRIENDLY_NORMAL(8, "International friendly (normal rules)"),
    INT_FRIENDLY_CUP(9, "Internation friendly (cup rules)"),
    NATIONAL_NORMAL(1, "National teams competition match (normal rules)"),
    NATIONAL_CUP(11, "National teams competition match (cup rules)"),
    NATIONAL_FRIENDLY(12, "National teams friendly"),
    TOURNAMENT_LEAGUE(50, "Tournament League match"),
    TOURNAMENT_PLAYOFF(51, "Tournament Playoff match"),
    SINGLE_MATCH(61, "Single match"),
    LADDER_MATCH(62, "Ladder match"),
    PREPARATION(80, "Preparation match"),
    YOUTH_MATCH(100, "Youth league match"),
    YOUTH_FRIENDLY(101, "Youth friendly match"),
    RESERVED_2(102, "RESERVED"),
    YOUTH_FRIENDLY_CUP(103, "Youth friendly match (cup rules)"),
    RESERVED_3(104, "RESERVED"),
    YOUTH_INT_FRIENDLY(105, "Youth international friendly match"),
    YOUTH_INT_FRIENDLY_CUP(106, "Youth international friendly match (Cup rules)"),
    RESERVED_4(107, "RESERVED");

    protected Integer value;
    protected String description;

    MatchType(Integer code, String description) {
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
    public static MatchType parse(Integer id) {
        MatchType matchType = null; // Default
        for (MatchType item : MatchType.values()) {
            if (item.getValue().equals(id)) {
                matchType = item;
                break;
            }
        }
        return matchType;
    }

    public static Map asMap() {
        MatchType[] values = MatchType.values();
        Map<Integer, String> result = new HashMap();
        for (int i = 0; i < values.length; i++) {
            result.put(values[i].getValue(), values[i].getDescription());
        }

        return result;
    }
}
