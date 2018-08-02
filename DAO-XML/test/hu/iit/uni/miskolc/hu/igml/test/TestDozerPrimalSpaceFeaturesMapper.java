package hu.iit.uni.miskolc.hu.igml.test;

import hu.iit.uni.miskolc.hu.daoxml.DozerPrimarySpaceFeatureMapper;
import net.opengis.indoorgml.core.PrimalSpaceFeatures;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesType;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TestDozerPrimalSpaceFeaturesMapper {


    @Test
    public void unmarshallGetIndoorFeatures() throws JAXBException {

        //Make unmarshalling to get a CellSpace to marshall
        File file = new File("resources/FJK-Haus_IndoorGML_withEXR-corrected(working).gml");

        JAXBContext jaxbContext = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IndoorFeaturesType indoorFeaturesType = (IndoorFeaturesType) ((javax.xml.bind.JAXBElement) jaxbUnmarshaller.unmarshal(file)).getValue();

        DozerPrimarySpaceFeatureMapper dozerPrimarySpaceFeatureMapper = new DozerPrimarySpaceFeatureMapper();
        PrimalSpaceFeatures primalSpaceFeatures=dozerPrimarySpaceFeatureMapper.copyPrimalSpaceFeatureFromPrimalSpaceFeaturePropertyType(indoorFeaturesType.getPrimalSpaceFeatures());
        PrimalSpaceFeaturesType primalSpaceFeaturesType=indoorFeaturesType.getPrimalSpaceFeatures().getPrimalSpaceFeatures();

        System.out.println(primalSpaceFeatures.getGmlID());
         System.out.println(primalSpaceFeatures.getCellSpaceOnFloors().size());
    }
}