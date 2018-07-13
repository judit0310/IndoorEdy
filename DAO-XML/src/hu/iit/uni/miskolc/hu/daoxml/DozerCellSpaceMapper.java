package hu.iit.uni.miskolc.hu.daoxml;

import indoorgml.iit.core.CellSpace;
import net.opengis.indoorgml.core.v_1_0.CellSpaceType;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DozerCellSpaceMapper {

    /**
     * Dozer-based converter.
     * @author Boro T.
     */

    static String file="resources/DozerCellSpaceMapping.xml";
    static DozerBeanMapper mapper = new DozerBeanMapper(Arrays.asList(new String[]{file}));

//    static {
//       DozerBeanMapper mapper = new DozerBeanMapper();
//         String file="resources/DozerCellSpaceMapping.xml";
//         mapper.setMappingFiles(Arrays.asList(new String[]{file}));



         // DozerBeanMapper mapper = new DozerBeanMapper(Arrays.asList(new String[]{file}));
           //List<String> mappingFilesNames = new ArrayList<>();
           //mappingFilesNames.add("resources/DozerCellSpaceMapping.xml");


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