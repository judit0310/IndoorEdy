package hu.iit.uni.miskolc.hu.daoxml;
import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.gml.v_3_2_1.LinearRingType;
import net.opengis.gml.v_3_2_1.PolygonType;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.geometry.Polygon;
import net.opengis.indoorgml.iit.*;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public class Mapper {


    public IndoorFeatures indoorFeaturesMapper (IndoorFeatures target ,IndoorFeaturesType indoorFeaturesType){
        MultiLayeredGraph multiLayeredGraph = createMultiLayeredGraph(null, indoorFeaturesType.getMultiLayeredGraph());
        target.setMultiLayeredGraph(multiLayeredGraph);

        PrimalSpaceFeatures primalSpaceFeatures = createPrimalSpaceFeatures(indoorFeaturesType.getPrimalSpaceFeatures());
        target.setPrimalSpaceFeatures(primalSpaceFeatures);
        return target;
    }

    public PrimalSpaceFeatures createPrimalSpaceFeatures(PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType) {
        PrimalSpaceFeatures target=new PrimalSpaceFeatures();

        PrimalSpaceFeaturesType primalSpaceFeaturesType = primalSpaceFeaturesPropertyType.getPrimalSpaceFeatures();

        ArrayList<CellSpaceMemberType> cellSpaceMemberTypeList =(ArrayList<CellSpaceMemberType>) primalSpaceFeaturesType.getCellSpaceMember();
        List<CellSpace> cellSpaceList = new ArrayList<CellSpace>();
        for(CellSpaceMemberType cellSpaceMemberType : cellSpaceMemberTypeList) {
            JAXBElement<CellSpaceType> jCellSpaceType = (JAXBElement<CellSpaceType>) cellSpaceMemberType.getCellSpace();
            CellSpaceType cellSpaceType = jCellSpaceType.getValue();

            CellSpace cellSpace = createCellSpace(cellSpaceType);

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
        return null;
    }


    public CellSpace createCellSpace(CellSpaceType cellSpaceType) {
        PolygonType polygonType = (PolygonType) cellSpaceType.getCellSpaceGeometry().getGeometry2D().getAbstractSurface().getValue();
        LinearRingType linearRingType= (LinearRingType) polygonType.getExterior().getAbstractRing().getValue();

        List<DirectPosition> directPositionList=new ArrayList<DirectPosition>();
        for(int i=0;i<linearRingType.getPosOrPointPropertyOrPointRep().size();i++){
            DirectPosition directPosition= (DirectPosition) linearRingType.getPosOrPointPropertyOrPointRep().get(i).getValue();
            directPositionList.add(directPosition);
        }
        LinearRingGml linearRingGml=new LinearRingGml();
        linearRingGml.setPosOrPointPropertyOrPointRep(directPositionList);

        PolygonGml polygonGml=new PolygonGml();
        polygonGml.setExterior(linearRingGml);

        CellSpace target=new CellSpace();
        target.setGeometry2D(polygonGml);
        return target;
    }


    private MultiLayeredGraph createMultiLayeredGraph(Object o, MultiLayeredGraphPropertyType multiLayeredGraph) {
        return null;
    }
}