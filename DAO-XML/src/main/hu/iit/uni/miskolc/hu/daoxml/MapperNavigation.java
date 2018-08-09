package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.indoorgml.core.SpaceLayer;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.iit.MultiLayeredGraph;

import java.util.ArrayList;
import java.util.List;

public class MapperNavigation {

    public MultiLayeredGraph multiLayeredGraphMapper(MultiLayeredGraphPropertyType multiLayeredGraphPropertyType){
        List<SpaceLayersType> spaceLayersTypeList = multiLayeredGraphPropertyType.getMultiLayeredGraph().getSpaceLayers();
        List<InterEdgesType> interEdgesTypeList = multiLayeredGraphPropertyType.getMultiLayeredGraph().getInterEdges();

        List<SpaceLayerType> spaceLayerTypeList=new ArrayList<>();
        List<List<SpaceLayerType>> spaceLayerTypeListList = new ArrayList<>();

        for(int i=0;i<spaceLayersTypeList.size();i++){
             List <SpaceLayerMemberType> spaceLayerMemberType = spaceLayersTypeList.get(i).getSpaceLayerMember();
                for (int j=0;j<spaceLayerMemberType.size();j++){
                    spaceLayerTypeList.add(spaceLayerMemberType.get(j).getSpaceLayer());
                }
                for (int k=0;j<spaceLayerTypeList.size();k++){
                spaceLayerTypeList.add(spaceLayerMemberType.get(j).getSpaceLayer())
            }

                spaceLayerTypeListList.add(spaceLayerTypeList);
        }



    MultiLayeredGraph multiLayeredGraph=new MultiLayeredGraph();
    return multiLayeredGraph;
    }
}