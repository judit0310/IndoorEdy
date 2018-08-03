package hu.iit.uni.miskolc.hu.daoxml;
import net.opengis.gml.v_3_2_1.*;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.iit.*;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public IndoorFeatures indoorFeaturesMapper(IndoorFeatures target, IndoorFeaturesType indoorFeaturesType) {
        MultiLayeredGraph multiLayeredGraph = createMultiLayeredGraph(null, indoorFeaturesType.getMultiLayeredGraph());
        target.setMultiLayeredGraph(multiLayeredGraph);

        PrimalSpaceFeatures primalSpaceFeatures = createPrimalSpaceFeatures(indoorFeaturesType.getPrimalSpaceFeatures());
        target.setPrimalSpaceFeatures(primalSpaceFeatures);
        return target;
    }

    private MultiLayeredGraph createMultiLayeredGraph(Object o, MultiLayeredGraphPropertyType multiLayeredGraph) {
        return null;
    }

    public PrimalSpaceFeatures createPrimalSpaceFeatures(PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType) {
        PrimalSpaceFeatures target = new PrimalSpaceFeatures();

        PrimalSpaceFeaturesType primalSpaceFeaturesType = primalSpaceFeaturesPropertyType.getPrimalSpaceFeatures();

        ArrayList<CellSpaceMemberType> cellSpaceMemberTypeList = (ArrayList<CellSpaceMemberType>) primalSpaceFeaturesType.getCellSpaceMember();
        List<CellSpaceIgml> cellSpaceIgmlList = new ArrayList<CellSpaceIgml>();
        for (CellSpaceMemberType cellSpaceMemberType : cellSpaceMemberTypeList) {
            JAXBElement<CellSpaceType> jCellSpaceType = (JAXBElement<CellSpaceType>) cellSpaceMemberType.getCellSpace();
            CellSpaceType cellSpaceType = jCellSpaceType.getValue();

            CellSpaceIgml cellSpaceIgml = createCellSpace3D(cellSpaceType);

            cellSpaceIgmlList.add(cellSpaceIgml);
        }
        ArrayList<CellSpaceMember> cellSpaceMemberList = null;

        for (int i = 0; i < cellSpaceIgmlList.size(); i++) {
            cellSpaceMemberList.get(i).setCellSpaceIgmls(cellSpaceIgmlList);
        }
        target.setCellSpaceMemberList(cellSpaceMemberList);

        ArrayList<CellSpaceBoundaryMemberType> cellSpaceBoundaryMemberTypeList = (ArrayList<CellSpaceBoundaryMemberType>) primalSpaceFeaturesType.getCellSpaceBoundaryMember();
        List<CellSpaceBoundary> cellSpaceBoundaryList = new ArrayList<CellSpaceBoundary>();
        for (CellSpaceBoundaryMemberType c : cellSpaceBoundaryMemberTypeList) {
            JAXBElement<CellSpaceBoundaryType> jCellSpaceBoundaryType = (JAXBElement<CellSpaceBoundaryType>) c.getCellSpaceBoundary();
            CellSpaceBoundaryType cellSpaceBoundaryType = jCellSpaceBoundaryType.getValue();
            CellSpaceBoundary cellSpaceBoundary = createCellSpaceBoundary(null, cellSpaceBoundaryType);
            cellSpaceBoundaryList.add(cellSpaceBoundary);
        }

        ArrayList<CellSpaceBoundaryMember> cellSpaceBoundaryMemberList = null;

        for (int i = 0; i < cellSpaceIgmlList.size(); i++) {
            cellSpaceBoundaryMemberList.get(i).setCellSpaceBoundaryMember(cellSpaceBoundaryList);
        }

        target.setCellSpaceBoundaryMemberList(cellSpaceBoundaryMemberList);
        return target;
    }

    private CellSpaceBoundary createCellSpaceBoundary(Object o, CellSpaceBoundaryType cellSpaceBoundaryType) {
        return null;
    }


    public CellSpaceIgml createCellSpace3D(CellSpaceType cellSpaceType) {
        SolidType solidType = (SolidType) cellSpaceType.getCellSpaceGeometry().getGeometry3D().getAbstractSolid().getValue();
        ShellType shellType = (ShellType) solidType.getExterior().getShell();
        List<SurfacePropertyType> surfacePropertyTypeList = shellType.getSurfaceMember();

        ArrayList<SurfaceType> surfaceTypeArrayList = new ArrayList<>();
        PolygonGml polygonGml = new PolygonGml();

        for (int i = 0; i < surfacePropertyTypeList.size(); i++) {
            surfaceTypeArrayList.set(i, (SurfaceType) surfacePropertyTypeList.get(i).getAbstractSurface().getValue());

            List<JAXBElement<? extends AbstractSurfacePatchType>> listAbstractSurfacePatchType = surfaceTypeArrayList.get(i).getPatches().getValue().getAbstractSurfacePatch();
            for (int j = 0; j < listAbstractSurfacePatchType.size(); j++) {
                LinearRingType linearRingType = (LinearRingType) (((PolygonPatchType) listAbstractSurfacePatchType.get(j).getValue()).getExterior().getAbstractRing().getValue());

                List<DirectPosition> directPositionList = new ArrayList<DirectPosition>();
                for (int z = 0; z < linearRingType.getPosOrPointPropertyOrPointRep().size(); z++) {
                    DirectPosition directPosition = (DirectPosition) linearRingType.getPosOrPointPropertyOrPointRep().get(i).getValue();
                    directPositionList.add(directPosition);
                }
                LinearRingGml linearRingGml = new LinearRingGml();
                linearRingGml.setPosOrPointPropertyOrPointRep(directPositionList);
                polygonGml.setExterior(linearRingGml);
            }
        }

        SolidGml solidGml=new SolidGml();
        CellSpaceIgml target=new CellSpaceIgml();
        target.setGeometry3D(solidGml);
        return target;
    }
}


//    public CellSpaceIgml createCellSpace3D(CellSpaceType cellSpaceType) {
//        PolygonType polygonType = (PolygonType) cellSpaceType.getCellSpaceGeometry().getGeometry3D().getAbstractSolid().getValue();
//        LinearRingType linearRingType= (LinearRingType) polygonType.getExterior().getAbstractRing().getValue();
//
//        List<DirectPosition> directPositionList=new ArrayList<DirectPosition>();
//        for(int i=0;i<linearRingType.getPosOrPointPropertyOrPointRep().size();i++){
//            DirectPosition directPosition= (DirectPosition) linearRingType.getPosOrPointPropertyOrPointRep().get(i).getValue();
//            directPositionList.add(directPosition);
//        }
//        LinearRingGml linearRingGml=new LinearRingGml();
//        linearRingGml.setPosOrPointPropertyOrPointRep(directPositionList);
//
//        PolygonGml polygonGml=new PolygonGml();
//        polygonGml.setExterior(linearRingGml);
//
//        CellSpaceIgml target=new CellSpaceIgml();
//        target.setGeometry2D(polygonGml);
//        return target;
//    }