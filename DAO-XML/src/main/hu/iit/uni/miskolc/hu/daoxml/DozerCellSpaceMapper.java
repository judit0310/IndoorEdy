package hu.iit.uni.miskolc.hu.daoxml;

import indoorgml.iit.core.CellSpace;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import org.dozer.DozerBeanMapper;
import java.util.Arrays;

public class DozerCellSpaceMapper {

    /**
     * Dozer-based converter.
     * @author Boro T.
     */

    private static DozerBeanMapper mapper;

    static {
        String file = "resources/DozerCellSpaceMapping.xml";
        DozerCellSpaceMapper.mapper = new DozerBeanMapper(Arrays.asList(new String[]{file}));
    }
    /*
     *  @param  instance of {@link indoorgml.iit.core.CellSpace}
     *  @return Instance of {@link net.opengis.indoorgml.core.v_1_0.CellSpaceType}
     */
    public CellSpaceType copyCellSpaceTypeFromCellSpace(CellSpace cellSpace) {
        CellSpaceType cellSpaceType=mapper.map(cellSpace, CellSpaceType.class);
        return cellSpaceType;
    }

    /*
     *  @param  instance of {@link net.opengis.indoorgml.core.v_1_0.CellSpaceType}
     *  @return instance of {@link indoorgml.iit.core.CellSpace}
     */
    public CellSpace copyCellSpaceFromCellSpaceType(CellSpaceType cellSpaceType){
        CellSpace cellSpace=mapper.map(cellSpaceType,CellSpace.class);
        return cellSpace;
    }
}
