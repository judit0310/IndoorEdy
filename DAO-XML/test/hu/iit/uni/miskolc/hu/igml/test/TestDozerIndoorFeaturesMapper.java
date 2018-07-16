package hu.iit.uni.miskolc.hu.igml.test;

import hu.iit.uni.miskolc.hu.daoxml.DozerCellSpaceMapper;
import indoorgml.iit.core.CellSpace;
import indoorgml.iit.core.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.CellSpaceMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import org.junit.Test;


import javax.xml.bind.*;
import java.io.File;


public class TestDozerIndoorFeaturesMapper {

    @Test
    public void unmarshallGetIndoorFeatures() throws JAXBException {

        //Make unmarshalling to get a CellSpace to marshall
        File file = new File("resources/FJK-Haus_IndoorGML_withEXR-corrected_1_0_3.gml");

        JAXBContext jaxbContext = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IndoorFeaturesType indoorFeaturesType = (IndoorFeaturesType) ((javax.xml.bind.JAXBElement) jaxbUnmarshaller.unmarshal(file)).getValue();

        DozerCellSpaceMapper dozerCellSpaceMapper=new DozerCellSpaceMapper();
        IndoorFeatures indoorFeaturesSpecific=dozerCellSpaceMapper.copyIndoorFeaturesFromIndoorFeaturesType(indoorFeaturesType);
        System.out.println(indoorFeaturesSpecific.getGmlID());
    }
}