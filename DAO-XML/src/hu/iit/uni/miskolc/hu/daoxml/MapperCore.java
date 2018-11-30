package hu.iit.uni.miskolc.hu.daoxml;

import edu.pnu.project.BoundaryType;
import net.opengis.gml.v_3_2_1.*;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.geometry.Shell;
import net.opengis.indoorgml.iit.*;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public class MapperCore {

    public MapperCore(){}

    public IndoorFeatures indoorFeaturesCreator(IndoorFeatures target, IndoorFeaturesType indoorFeaturesType) {
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
        ArrayList<CellSpaceMember> cellSpaceMemberList = new ArrayList<>();

        for (int i = 0; i < cellSpaceIgmlList.size(); i++) {
            CellSpaceMember cellSpaceMember=new CellSpaceMember();
            cellSpaceMember.setCellSpaceIgmls(cellSpaceIgmlList);
            cellSpaceMemberList.add(cellSpaceMember);


           // cellSpaceMemberList.get(i).setCellSpaceIgmls(cellSpaceIgmlList);
        }
        target.setCellSpaceMemberList(cellSpaceMemberList);



        ArrayList<CellSpaceBoundaryMemberType> cellSpaceBoundaryMemberTypeList = (ArrayList<CellSpaceBoundaryMemberType>) primalSpaceFeaturesType.getCellSpaceBoundaryMember();
        List<CellSpaceBoundary> cellSpaceBoundaryList = new ArrayList<CellSpaceBoundary>();
        System.out.println("abrakadabra");
        for (CellSpaceBoundaryMemberType c : cellSpaceBoundaryMemberTypeList) {
            JAXBElement<CellSpaceBoundaryType> jCellSpaceBoundaryType = (JAXBElement<CellSpaceBoundaryType>) c.getCellSpaceBoundary();
            CellSpaceBoundaryType cellSpaceBoundaryType = jCellSpaceBoundaryType.getValue();
            CellSpaceBoundary cellSpaceBoundary = createCellSpaceBoundary(cellSpaceBoundaryType);
            System.out.println("abrakadabra");
            cellSpaceBoundaryList.add(cellSpaceBoundary);
        }

        System.out.println("abrakadabra");
        target.setCellSpaceBoundaryList(cellSpaceBoundaryList); //Adding List<CellSpaceBoundary> to PrimarySF.
        return target;
    }


    // none of the gml files was using CellSpaceBoundary
    private CellSpaceBoundary createCellSpaceBoundary(CellSpaceBoundaryType cellSpaceBoundaryMemberType) {
        AbstractSurfaceType abstractSurfaceType = (AbstractSurfaceType) cellSpaceBoundaryMemberType.getCellSpaceBoundaryGeometry().getGeometry3D().getAbstractSurface().getValue();

        CellSpaceBoundary cellSpaceBoundary = new CellSpaceBoundary();
        if(abstractSurfaceType instanceof PolygonType){
            PolygonType polygonType=(PolygonType) abstractSurfaceType;
        }
        else if (abstractSurfaceType instanceof OrientableSurfaceType){
            OrientableSurfaceType orientableSurfaceType=(OrientableSurfaceType) abstractSurfaceType;
        }

        BoundaryType boundaryType=BoundaryType.CellSpaceBoundary;
        cellSpaceBoundary.setBoundaryType(boundaryType);
        PolygonGml polygonGml=new PolygonGml();
        cellSpaceBoundary.setGeometry3D(polygonGml);
        return cellSpaceBoundary;
    }


    public CellSpaceIgml createCellSpace3D(CellSpaceType cellSpaceType) {
        SolidType solidType = (SolidType) cellSpaceType.getCellSpaceGeometry().getGeometry3D().getAbstractSolid().getValue();
        ShellType shellType = solidType.getExterior().getShell();
        List<SurfacePropertyType> surfacePropertyTypeList = shellType.getSurfaceMember();

        ArrayList<SurfaceType> surfaceTypeArrayList = new ArrayList<>();
        ArrayList<PolygonGml> polygonGml = new ArrayList<>();

        ArrayList<LinearRingType> linearRingTypeArrayList = new ArrayList<>();
        ArrayList<PolygonType> polygonTypeArrayList = new ArrayList<>();

        for (int i = 0; i < surfacePropertyTypeList.size(); i++) {
            polygonTypeArrayList.add((PolygonType) surfacePropertyTypeList.get(i).getAbstractSurface().getValue());
            linearRingTypeArrayList.add((LinearRingType) polygonTypeArrayList.get(i).getExterior().getAbstractRing().getValue());
        }


        List<DirectPosition> directPositionList = new ArrayList<DirectPosition>();

        for (int j = 0; j < linearRingTypeArrayList.size(); j++) {
            for (int k = 0; k < linearRingTypeArrayList.get(j).getPosOrPointPropertyOrPointRep().size(); k++) {
                //directPositionList.add((DirectPosition) linearRingTypeArrayList.get(j).getPosOrPointPropertyOrPointRep().get(k).getValue());

                DirectPositionType directPositionType = (DirectPositionType) linearRingTypeArrayList.get(j).getPosOrPointPropertyOrPointRep().get(k).getValue();
                directPositionList.add(new DirectPosition((ArrayList)directPositionType.getValue()));
            }

            LinearRingGml linearRingGml = new LinearRingGml();
            linearRingGml.setPosOrPointPropertyOrPointRep(directPositionList);

            polygonGml.add(new PolygonGml(linearRingGml,null));
        }

        SolidGml solidGml = new SolidGml();
        Shell shell=new Shell();
        shell.setSurfaceMember(polygonGml);
        solidGml.setExteriorShell(shell);
        CellSpaceIgml target = new CellSpaceIgml();
        target.setGeometry3D(solidGml);
        return target;
        }
    }


//    public CellSpaceIgml createCellSpace2D(CellSpaceType cellSpaceType) {
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


//    public CellSpaceIgml createCellSpace3D(CellSpaceType cellSpaceType) {
//        SolidType solidType = (SolidType) cellSpaceType.getCellSpaceGeometry().getGeometry3D().getAbstractSolid().getValue();
//        ShellType shellType = (ShellType) solidType.getExterior().getShell();
//        List<SurfacePropertyType> surfacePropertyTypeList = shellType.getSurfaceMember();
//
//        ArrayList<SurfaceType> surfaceTypeArrayList = new ArrayList<>();
//        PolygonGml polygonGml = new PolygonGml();
//
//        for (int i = 0; i < surfacePropertyTypeList.size(); i++) {
//            surfaceTypeArrayList.set(i, (SurfaceType) surfacePropertyTypeList.get(i).getAbstractSurface().getValue());
//
//
//            List<JAXBElement<? extends AbstractSurfacePatchType>> listAbstractSurfacePatchType = surfaceTypeArrayList.get(i).getPatches().getValue().getAbstractSurfacePatch();
//            for (int j = 0; j < listAbstractSurfacePatchType.size(); j++) {
//                LinearRingType linearRingType = (LinearRingType) (((PolygonPatchType) listAbstractSurfacePatchType.get(j).getValue()).getExterior().getAbstractRing().getValue());
//
//                List<DirectPosition> directPositionList = new ArrayList<DirectPosition>();
//                for (int z = 0; z < linearRingType.getPosOrPointPropertyOrPointRep().size(); z++) {
//                    DirectPosition directPosition = (DirectPosition) linearRingType.getPosOrPointPropertyOrPointRep().get(i).getValue();
//                    directPositionList.add(directPosition);
//                }
//                LinearRingGml linearRingGml = new LinearRingGml();
//                linearRingGml.setPosOrPointPropertyOrPointRep(directPositionList);
//                polygonGml.setExterior(linearRingGml);
//            }
//        }
//        SolidGml solidGml=new SolidGml();
//        CellSpaceIgml target=new CellSpaceIgml();
//        target.setGeometry3D(solidGml);
//        return target;
//    }
//}