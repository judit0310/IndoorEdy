package net.opengis.indoorgml.iit;

import java.util.List;

public class PolygonGml {
    private LinearRingGml exterior;
    private List<LinearRingGml> interior;

    public PolygonGml(){ }

    public PolygonGml(LinearRingGml exterior, List<LinearRingGml> interiror) {
        this.exterior = exterior;
        this.interior = interior;
    }

    public List<LinearRingGml> getInterior() {
        return interior;
    }

    public void setInterior(List<LinearRingGml> interior) {
        this.interior = interior;
    }

    public List<LinearRingGml> getInteriror() {
        return interior;
    }

    public LinearRingGml getExterior() {
        return exterior;
    }

    public void setExterior(LinearRingGml exterior) {
        this.exterior = exterior;
    }

    public LinearRingGml getExteriorRing() {
        return exterior;
    }
}
