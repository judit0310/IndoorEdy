package net.opengis.indoorgml.iit;

import java.util.List;

public class LineStringSegment {

    public LineStringSegment(List<?> posOrPointPropertyOrPointRep, List<DirectPosition> directPositionList, CoordinatesGml coordinates) {
        this.posOrPointPropertyOrPointRep = posOrPointPropertyOrPointRep;
        this.directPositionList = directPositionList;
        this.coordinates = coordinates;
    }

    protected List<?> posOrPointPropertyOrPointRep;
    private List<DirectPosition> directPositionList;
    private CoordinatesGml coordinates;

    public List<?> getPosOrPointPropertyOrPointRep() {
        return posOrPointPropertyOrPointRep;
    }

    public void setPosOrPointPropertyOrPointRep(List<?> posOrPointPropertyOrPointRep) {
        this.posOrPointPropertyOrPointRep = posOrPointPropertyOrPointRep;
    }

    public List<DirectPosition> getDirectPositionList() {
        return directPositionList;
    }

    public void setDirectPositionList(List<DirectPosition> directPositionList) {
        this.directPositionList = directPositionList;
    }

    public CoordinatesGml getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesGml coordinates) {
        this.coordinates = coordinates;
    }
}
