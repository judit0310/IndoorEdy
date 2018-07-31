package net.opengis.indoorgml.iit;

import javax.xml.bind.annotation.XmlAttribute;

public class MeasureGml {
    private double value;
    private String uom;

    public MeasureGml(double value, String uom) {
        this.value = value;
        this.uom = uom;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
