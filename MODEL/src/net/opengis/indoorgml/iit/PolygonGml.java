package net.opengis.indoorgml.iit;

import java.util.List;

public class PolygonGml {
    private LinearRingGml exterior;
    private List<LinearRingGml> interior;

    public List<LinearRingGml> getInterior() {
        return interior;
    }

    public void setInterior(List<LinearRingGml> interior) {
        this.interior = interior;
    }



    public PolygonGml(LinearRingGml exterior, List<LinearRingGml> interiror) {
        this.exterior = exterior;
        this.interiror = interiror;
    }

    public List<LinearRingGml> getInteriror() {
        return interiror;
    }

    public void setInteriror(List<LinearRingGml> interiror) {
        this.interiror = interiror;
    }

    private List<LinearRingGml> interiror;

    public LinearRingGml getExterior() {
        return exterior;
    }

    public void setExterior(LinearRingGml exterior) {
        this.exterior = exterior;
    }
}
