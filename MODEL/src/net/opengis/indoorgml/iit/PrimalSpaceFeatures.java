package net.opengis.indoorgml.iit;

import java.util.List;

public class PrimalSpaceFeatures {
    private List<CellSpaceMember> cellSpaceMemberList;
    private List<CellSpaceBoundary> cellSpaceBoundaryList;

    public PrimalSpaceFeatures(){
    }

    public PrimalSpaceFeatures(List<CellSpaceMember> cellSpaceMemberList, List<CellSpaceBoundary> cellSpaceBoundaryList) {
        this.cellSpaceMemberList = cellSpaceMemberList;
        this.cellSpaceBoundaryList = cellSpaceBoundaryList;

    }

    public List<CellSpaceMember> getCellSpaceMemberList() {
        return cellSpaceMemberList;
    }

    public void setCellSpaceMemberList(List<CellSpaceMember> cellSpaceMemberList) {
        this.cellSpaceMemberList = cellSpaceMemberList;
    }

    public List<CellSpaceBoundary> getCellSpaceBoundaryList() {
        return cellSpaceBoundaryList;
    }

    public void setCellSpaceBoundaryList(List<CellSpaceBoundary> cellSpaceBoundaryList) {
        this.cellSpaceBoundaryList = cellSpaceBoundaryList;
    }
}
