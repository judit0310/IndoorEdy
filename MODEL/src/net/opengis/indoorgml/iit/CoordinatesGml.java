package net.opengis.indoorgml.iit;

public class CoordinatesGml {

    public CoordinatesGml(String value, String decimal, String cs, String ts) {
        this.value = value;
        this.decimal = decimal;
        this.cs = cs;
        this.ts = ts;
    }

    private String value;
    private String decimal;
    private String cs;
    private String ts;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
