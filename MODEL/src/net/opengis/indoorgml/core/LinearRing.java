package net.opengis.indoorgml.core;

import java.util.List;

public class LinearRing {

    private List<DirectPosition> posList;

    public LinearRing() {
    }

    public LinearRing(List<DirectPosition> posList) {
        this.posList = posList;
    }

    public List<DirectPosition> getPosList() {
        return posList;
    }

    public void setPosList(List<DirectPosition> posList) {
        this.posList = posList;
    }
}
