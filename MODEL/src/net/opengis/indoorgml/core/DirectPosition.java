package net.opengis.indoorgml.core;

import java.util.List;


/*
* Coordinates of a point(like x, y, z)
*/

public class DirectPosition {

    public DirectPosition(){}

    public DirectPosition(List<Double> value) {
        this.value = value;
    }

    public List<Double> getValue() {
        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    private List<Double> value;
}
