package hu.iit.uni.miskolc.hu.daoxml;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.iit.*;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public class Mapper {


    public IndoorFeatures indoorFeaturesMapper (IndoorFeatures target ,IndoorFeaturesType indoorFeaturesType){
        MultiLayeredGraph multiLayeredGraph = createMultiLayeredGraph(null, indoorFeaturesType.getMultiLayeredGraph());
        target.setMultiLayeredGraph(multiLayeredGraph);

        PrimalSpaceFeatures primalSpaceFeatures = createPrimalSpaceFeatures(null, indoorFeaturesType.getPrimalSpaceFeatures());
        target.setPrimalSpaceFeatures(primalSpaceFeatures);
        return target;
    }

    private PrimalSpaceFeatures createPrimalSpaceFeatures(PrimalSpaceFeatures target, PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType) {

        PrimalSpaceFeaturesType primalSpaceFeaturesType = primalSpaceFeaturesPropertyType.getPrimalSpaceFeatures();

        ArrayList<CellSpaceMemberType> cellSpaceMemberTypeList =(ArrayList<CellSpaceMemberType>) primalSpaceFeaturesType.getCellSpaceMember();
        List<CellSpace> cellSpaceList = new ArrayList<CellSpace>();
        for(CellSpaceMemberType cellSpaceMemberType : cellSpaceMemberTypeList) {
            JAXBElement<CellSpaceType> jCellSpaceType = (JAXBElement<CellSpaceType>) cellSpaceMemberType.getCellSpace();
            CellSpaceType cellSpaceType = jCellSpaceType.getValue();
            CellSpace cellSpace = createCellSpace(null, cellSpaceType);
            cellSpaceList.add(cellSpace);
        }
        ArrayList<CellSpaceMember> cellSpaceMemberList = null;

        for (int i=0;i<cellSpaceList.size();i++) {
            cellSpaceMemberList.get(i).setCellSpaces(cellSpaceList);
        }
        target.setCellSpaceMemberList(cellSpaceMemberList);

        ArrayList<CellSpaceBoundaryMemberType> cellSpaceBoundaryMemberTypeList = (ArrayList<CellSpaceBoundaryMemberType>) primalSpaceFeaturesType.getCellSpaceBoundaryMember();
        List<CellSpaceBoundary> cellSpaceBoundaryList = new ArrayList<CellSpaceBoundary>();
        for(CellSpaceBoundaryMemberType c : cellSpaceBoundaryMemberTypeList) {
            JAXBElement<CellSpaceBoundaryType> jCellSpaceBoundaryType = (JAXBElement<CellSpaceBoundaryType>) c.getCellSpaceBoundary();
            CellSpaceBoundaryType cellSpaceBoundaryType = jCellSpaceBoundaryType.getValue();
            CellSpaceBoundary cellSpaceBoundary = createCellSpaceBoundary(null, cellSpaceBoundaryType);
            cellSpaceBoundaryList.add(cellSpaceBoundary);
        }

        ArrayList<CellSpaceBoundaryMember> cellSpaceBoundaryMemberList = null;

        for (int i=0;i<cellSpaceList.size();i++) {
            cellSpaceBoundaryMemberList.get(i).setCellSpaceBoundaryMember(cellSpaceBoundaryList);
        }

        target.setCellSpaceBoundaryMemberList(cellSpaceBoundaryMemberList);
        return target;
    }

    private CellSpaceBoundary createCellSpaceBoundary(Object o, CellSpaceBoundaryType cellSpaceBoundaryType) {
    }

    private CellSpace createCellSpace(Object o, CellSpaceType cellSpaceType) {
    }

    private MultiLayeredGraph createMultiLayeredGraph(Object o, MultiLayeredGraphPropertyType multiLayeredGraph) {
        return null;
    }

    public PrimalSpaceFeatures primalSpaceFeaturesMapper(PrimalSpaceFeaturesType primalSpaceFeaturesType) {
        PrimalSpaceFeatures primalSpaceFeatures = new PrimalSpaceFeatures();
        return  primalSpaceFeatures;
    }
}