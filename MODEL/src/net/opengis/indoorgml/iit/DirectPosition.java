package net.opengis.indoorgml.iit;

import java.util.ArrayList;

/*
*  Contains coordinates of a position.
*/
public class DirectPosition {
    public DirectPosition(ArrayList<Double> posCoordinates) {
        this.posCoordinates = posCoordinates;
    }

    public ArrayList<Double> getPosCoordinates() {
        return posCoordinates;
    }

    public void setPosCoordinates(ArrayList<Double> posCoordinates) {
        this.posCoordinates = posCoordinates;
    }

    private ArrayList<Double> posCoordinates;

}
