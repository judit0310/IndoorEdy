package net.opengis.indoorgml.iit;

import net.opengis.indoorgml.geometry.LineString;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinearRingGml extends LineString {

    //Contains coordinates list of a cellspace

    private List<DirectPosition> posOrPointPropertyOrPointRep;  // ---->
    private DirectPositionList posList;
    private CoordinatesGml coordinates;

    public LinearRingGml(List<DirectPosition> posOrPointPropertyOrPointRep, DirectPositionList posList, CoordinatesGml coordinates) {
        this.posOrPointPropertyOrPointRep = posOrPointPropertyOrPointRep;
        this.posList = posList;
        this.coordinates = coordinates;
    }

    public LinearRingGml() {
    }

    public List<DirectPosition> getPosOrPointPropertyOrPointRep() {
        return posOrPointPropertyOrPointRep;
    }

    public void setPosOrPointPropertyOrPointRep(List<DirectPosition> posOrPointPropertyOrPointRep) {
        this.posOrPointPropertyOrPointRep = posOrPointPropertyOrPointRep;
    }

    public DirectPositionList getPosList() {
        return posList;
    }

    public void setPosList(DirectPositionList posList) {
        this.posList = posList;
    }

    public CoordinatesGml getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesGml coordinates) {
        this.coordinates = coordinates;
    }
}