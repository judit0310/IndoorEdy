package net.opengis.indoorgml.iit;

import net.opengis.indoorgml.iit.CellSpaceBoundary;

import java.util.ArrayList;
import java.util.List;

public class CellSpaceBoundaryMember {

    public ArrayList<CellSpaceBoundary> getCellSpaceBoundaryMember() {
        return cellSpaceBoundaryMember;
    }

    public void setCellSpaceBoundaryMember(List<CellSpaceBoundary> cellSpaceBoundaryMember) {
        this.cellSpaceBoundaryMember = cellSpaceBoundaryMember;
    }

    private ArrayList<CellSpaceBoundary> cellSpaceBoundaryMember;
}
