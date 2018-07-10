package hu.iit.uni.miskolc.hu.igml.test;

import net.opengis.indoorgml.core.v_1_0.CellSpaceMemberType;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import hu.iit.uni.miskolc.hu.daoxml.*;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DozerCellSpaceMapperTest {
    public static void main(String[] args) throws JAXBException {

        //Make unmarshalling to get a CellSpace to marshall

        File file = new File("FJK-Haus_IndoorGML_withEXR-corrected_1_0_3.gml");
        JAXBContext jaxbContext = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        IndoorFeaturesType indoorFeaturesType = (IndoorFeaturesType) ((javax.xml.bind.JAXBElement) jaxbUnmarshaller.unmarshal(file)).getValue();

        List<CellSpaceMemberType> cellSpaceMemberTypeList=new ArrayList<>();
        cellSpaceMemberTypeList=indoorFeaturesType.getPrimalSpaceFeatures().getPrimalSpaceFeatures().getCellSpaceMember();

        System.out.println("ID of first cellSpace: " + cellSpaceMemberTypeList.get(0).getCellSpace().getValue());
        System.out.println("Data of first cellSpace: " + cellSpaceMemberTypeList.get(0).getCellSpace().getValue().toString());
        JAXBElement<? extends CellSpaceType> cellSpaceTypeSpecific=cellSpaceMemberTypeList.get(1).getCellSpace();

        try {
            File fileForMarshalling = new File("C:\\Users\\Foxx\\Desktop\\generatedFile.xml");
            JAXBContext jaxbContextForMarshalling = JAXBContext.newInstance("net.opengis.indoorgml.core.v_1_0:net.opengis.indoorgml.navigation.v_1_0");
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            System.out.println("\nGenerated file content:");
            jaxbMarshaller.marshal(cellSpaceTypeSpecific, System.out);
            jaxbMarshaller.marshal(cellSpaceTypeSpecific, fileForMarshalling);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}