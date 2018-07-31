package net.opengis.indoorgml.iit;

import java.util.List;

public class PrimalSpaceFeatures {
    private List<CellSpaceMember> cellSpaceMemberList;
    private List<CellSpaceBoundaryMember> cellSpaceBoundaryMemberList;

    public PrimalSpaceFeatures(){
    }

    public PrimalSpaceFeatures(List<CellSpaceMember> cellSpaceMemberList, List<CellSpaceBoundaryMember> cellSpaceBoundaryMemberList) {
        this.cellSpaceMemberList = cellSpaceMemberList;
        this.cellSpaceBoundaryMemberList = cellSpaceBoundaryMemberList;

    }

    public List<CellSpaceMember> getCellSpaceMemberList() {
        return cellSpaceMemberList;
    }

    public void setCellSpaceMemberList(List<CellSpaceMember> cellSpaceMemberList) {
        this.cellSpaceMemberList = cellSpaceMemberList;
    }

    public List<CellSpaceBoundaryMember> getCellSpaceBoundaryMemberList() {
        return cellSpaceBoundaryMemberList;
    }

    public void setCellSpaceBoundaryMemberList(List<CellSpaceBoundaryMember> cellSpaceBoundaryMemberList) {
        this.cellSpaceBoundaryMemberList = cellSpaceBoundaryMemberList;
    }
}
