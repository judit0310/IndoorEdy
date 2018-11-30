package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.indoorgml.core.PrimalSpaceFeatures;
import net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturesPropertyType;
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
     *  @param  instance of {@link PrimalSpaceFeatures}
     *  @return Instance of {@link net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturePropertyType}
     */
    public PrimalSpaceFeaturesPropertyType copyPrimalSpaceFeaturesPropertyTypeFromPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
        PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType=mapper.map(primalSpaceFeatures, PrimalSpaceFeaturesPropertyType.class);
        return primalSpaceFeaturesPropertyType;
    }

    /*
     *  @param  instance of {@link net.opengis.indoorgml.core.v_1_0.PrimalSpaceFeaturePropertyType}
     *  @return instance of {@link PrimalSpaceFeatures}
     */
    public PrimalSpaceFeatures copyPrimalSpaceFeatureFromPrimalSpaceFeaturePropertyType(PrimalSpaceFeaturesPropertyType primalSpaceFeaturesPropertyType){
        PrimalSpaceFeatures primalSpaceFeatures=mapper.map(primalSpaceFeaturesPropertyType,PrimalSpaceFeatures.class);
        return primalSpaceFeatures;
    }


}
