package net.opengis.indoorgml.iit;

import java.util.ArrayList;

/*
*  Contains coordinates of a position / Point.
*/
public class DirectPosition {

    private ArrayList<Double> coordinatesOfPoint;  ///------> END

    public DirectPosition(ArrayList<Double> coordinatesOfPoint) {

        this.coordinatesOfPoint = coordinatesOfPoint;
    }

    public ArrayList<Double> getCoordinatesOfPoint() {
        return coordinatesOfPoint;
    }

    public void setCoordinatesOfPoint(ArrayList<Double> coordinatesOfPoint) {
        this.coordinatesOfPoint = coordinatesOfPoint;
    }

}
