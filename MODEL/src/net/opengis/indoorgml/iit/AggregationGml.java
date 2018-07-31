package net.opengis.indoorgml.iit;

public enum AggregationGml {
    SET,
    BAG,
    SEQUENCE,
    ARRAY,
    RECORD,
    TABLE;

    private final String value;

    AggregationGml(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static net.opengis.gml.v_3_2_1.AggregationType fromValue(String v) {
        for (net.opengis.gml.v_3_2_1.AggregationType c: net.opengis.gml.v_3_2_1.AggregationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}