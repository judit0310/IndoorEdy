package hu.iit.uni.miskolc.hu.igml.test;


import hu.iit.uni.miskolc.hu.daoxml.DozerIndoorFeaturesMapper;
import net.opengis.indoorgml.core.IndoorFeatures;
import net.opengis.indoorgml.core.PrimalSpaceFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import org.junit.Test;


import javax.xml.bind.*;
import java.io.File;

public class TestDozerIndoorFeaturesMapperCore {

    @Test
    public void unmarshallGetIndoorFeatures() throws JAXBException {

        //Make unmarshalling to get a CellSpaceIgml to marshall
        File file = new File("resources/FJK-Haus_IndoorGML_withEXR-corrected(working).gml");

        JAXBContext jaxbContext = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IndoorFeaturesType indoorFeaturesType = (IndoorFeaturesType) ((javax.xml.bind.JAXBElement) jaxbUnmarshaller.unmarshal(file)).getValue();

        DozerIndoorFeaturesMapper dozerIndoorFeaturesMapper = new DozerIndoorFeaturesMapper();
        IndoorFeatures indoorFeaturesSpecific=dozerIndoorFeaturesMapper.copyIndoorFeaturesFromIndoorFeaturesType(indoorFeaturesType);

        System.out.println(indoorFeaturesSpecific.getGmlID() +"  "+ indoorFeaturesSpecific.getName() +" ");
    }
}