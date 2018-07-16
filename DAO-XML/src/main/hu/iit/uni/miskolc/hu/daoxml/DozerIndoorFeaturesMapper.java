package hu.iit.uni.miskolc.hu.daoxml;

import indoorgml.iit.core.CellSpace;
import indoorgml.iit.core.IndoorFeatures;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import org.dozer.DozerBeanMapper;
import java.util.Arrays;

public class DozerIndoorFeaturesMapper {

    /**
     * Dozer-based converter.
     * @author Boro T.
     */

    private static DozerBeanMapper mapper;

    static {
        String file = "resources/DozerCellSpaceMapping.xml";
        DozerIndoorFeaturesMapper.mapper = new DozerBeanMapper(Arrays.asList(new String[]{file}));
    }


    public IndoorFeaturesType copyIndoorFeaturesTypeFromIndoorFeatures(IndoorFeatures indoorFeatures) {
        IndoorFeaturesType indoorFeaturesType=mapper.map(indoorFeatures, IndoorFeaturesType.class);
        return indoorFeaturesType;
    }

    public IndoorFeatures copyIndoorFeaturesFromIndoorFeaturesType(IndoorFeaturesType indoorFeaturesType){
        IndoorFeatures indoorFeatures=mapper.map(indoorFeaturesType,IndoorFeatures.class);
        return indoorFeatures;
    }
}
