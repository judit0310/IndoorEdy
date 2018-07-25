package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.gml.v_3_2_1.LinearRingType;

import java.util.List;

public class JaxbToDomainMapper {

    /*
    Get the coordinates of a cellspace from the specific Jaxb class
     */
    public List<Double> createCoordinates(DirectPositionType directPositionType){
        List<Double> coordinates = directPositionType.getValue();
        return coordinates;
    }

    public LinearRing createLinearRing()

}