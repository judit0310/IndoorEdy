package hu.iit.uni.miskolc.hu.igml.test;

import hu.iit.uni.miskolc.hu.daoxml.MapperCore;
import hu.iit.uni.miskolc.hu.daoxml.MapperNavigation;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import net.opengis.indoorgml.iit.MultiLayeredGraph;
import net.opengis.indoorgml.iit.PrimalSpaceFeatures;
import org.junit.Test;

import javax.xml.bind.*;
import java.io.File;


public class TestNavigationPart {

    @Test
    public void unmarshallGetCellSpace() throws JAXBException {

        //Make unmarshalling to get a CellSpaceIgml to marshall
        File file = new File("resources/asdf.gml");

        JAXBContext jaxbContext = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IndoorFeaturesType indoorFeaturesType = (IndoorFeaturesType) ((javax.xml.bind.JAXBElement) jaxbUnmarshaller.unmarshal(file)).getValue();

        MapperCore mapperCore =new MapperCore();
        PrimalSpaceFeatures primalSpaceFeatures;
        primalSpaceFeatures = mapperCore.createPrimalSpaceFeatures(indoorFeaturesType.getPrimalSpaceFeatures());
        System.out.println(primalSpaceFeatures.getCellSpaceMemberList().get(0).getCellSpaceIgmls().get(0).getGeometry3D().getExteriorShell().getSurfaceMember().get(0).getExterior().getPosOrPointPropertyOrPointRep().get(0).getCoordinatesOfPoint().get(0).doubleValue());

        MapperNavigation mapperNavigation = new MapperNavigation();
        MultiLayeredGraph multiLayeredGraph = mapperNavigation.multiLayeredGraphMapper(indoorFeaturesType.getMultiLayeredGraph());

        System.out.println("MultilayeredGraph");
        System.out.println(multiLayeredGraph.getSpaceLayers().size());



        // System.out.println(primalSpaceFeatures.getCellSpaceMemberList().get(0).getCellSpaceIgmls().get(0).getGeometry3D().getExteriorShell().getSurfaceMember().get(0).getExteriorRing().getPoints().get(0).getPanelX());
//        try {
//            File fileForMarshalling = new File("C:\\Users\\Foxx\\Desktop\\generatedFile.xml");
//            JAXBContext jaxbContextForMarshalling = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // output pretty printed
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            System.out.println("\nGenerated file content:");
//            jaxbMarshaller.marshal(cellSpaceTypeSpecific, System.out);
//            jaxbMarshaller.marshal(cellSpaceTypeSpecific, fileForMarshalling);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
    }
}