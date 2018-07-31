package net.opengis.indoorgml.iit;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public class LinearRingGml {

    //Contains coordinates list of a cellspace

    private List<?> posOrPointPropertyOrPointRep;
    private ArrayList<DirectPosition> posList;
    private CoordinatesGml coordinates;

    public LinearRingGml(List<JAXBElement<?>> posOrPointPropertyOrPointRep, ArrayList<DirectPosition> posList, CoordinatesGml coordinates) {
        this.posOrPointPropertyOrPointRep = posOrPointPropertyOrPointRep;
        this.posList = posList;
        this.coordinates = coordinates;
    }

    public LinearRingGml() {
    }

    public List<?> getPosOrPointPropertyOrPointRep() {
        return posOrPointPropertyOrPointRep;
    }

    public void setPosOrPointPropertyOrPointRep(List<?> posOrPointPropertyOrPointRep) {
        this.posOrPointPropertyOrPointRep = posOrPointPropertyOrPointRep;
    }

    public ArrayList<DirectPosition> getPosList() {
        return posList;
    }

    public void setPosList(ArrayList<DirectPosition> posList) {
        this.posList = posList;
    }

    public CoordinatesGml getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesGml coordinates) {
        this.coordinates = coordinates;
    }
}