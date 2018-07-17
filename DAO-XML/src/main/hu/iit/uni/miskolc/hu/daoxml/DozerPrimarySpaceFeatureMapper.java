package hu.iit.uni.miskolc.hu.daoxml;

import indoorgml.iit.core.CellSpace;
import indoorgml.iit.core.IndoorFeatures;
import indoorgml.iit.core.PrimalSpaceFeatures;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import net.opengis.indoorgml.core.v_1_0.IndoorFeaturesType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesPropertyType;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesType;
import org.dozer.DozerBeanMapper;

import java.util.Arrays;

public class DozerPrimarySpaceFeatureMapper {

    /**
     * Dozer-based converter.
     * @author Boro T.
     */

    private static DozerBeanMapper mapper;

    static {
        String file = "resources/DozerCellSpaceMapping.xml";
        mapper = new DozerBeanMapper(Arrays.asList(new String[]{file}));
    }
    /*
     *  @param  instance of {@link indoorgml.iit.core.PrimalSpaceFeatures}
     *  @return Instance of {@link net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturePropertyType}
     */
    public PrimalSpaceFeaturesPropertyType copyPrimalSpaceFeaturesPropertyTypeFromPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
        PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType=mapper.map(primalSpaceFeatures, PrimalSpaceFeaturesPropertyType.class);
        return primalSpaceFeaturesPropertyType;
    }

    /*
     *  @param  instance of {@link net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturePropertyType}
     *  @return instance of {@link indoorgml.iit.core.PrimalSpaceFeatures}
     */
    public PrimalSpaceFeatures copyPrimalSpaceFeatureFromPrimalSpaceFeaturePropertyType(PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType){
        PrimalSpaceFeatures primalSpaceFeatures=mapper.map(primalSpaceFeaturesPropertyType,PrimalSpaceFeatures.class);
        return primalSpaceFeatures;
    }


}
