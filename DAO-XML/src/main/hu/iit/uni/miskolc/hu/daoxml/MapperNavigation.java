package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.indoorgml.core.SpaceLayers;
import net.opengis.indoorgml.core.State;
import net.opengis.indoorgml.core.StateOnFloor;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.geometry.Point;
import net.opengis.indoorgml.iit.MultiLayeredGraph;
import net.opengis.indoorgml.iit.Nodes;
import net.opengis.indoorgml.iit.SpaceLayer;

import java.util.ArrayList;
import java.util.List;

public class MapperNavigation {

    public MultiLayeredGraph multiLayeredGraphMapper(MultiLayeredGraphPropertyType multiLayeredGraphPropertyType) {

        List<SpaceLayersType> spaceLayersTypeList = multiLayeredGraphPropertyType.getMultiLayeredGraph().getSpaceLayers();

        List<SpaceLayerMemberType> spaceLayerMemberType=new ArrayList<>();
        List<SpaceLayerType> spaceLayerTypeList = new ArrayList<>();
        ArrayList<SpaceLayer> spaceLayerList = new ArrayList<>();
        ArrayList<SpaceLayers> spaceLayerS = new ArrayList<>();
        List<Nodes> nodesList = new ArrayList<>();
        ArrayList <StateOnFloor> stateOnFloor=new ArrayList<>();
        StateOnFloor stateFloor=new StateOnFloor();
        ArrayList<State> stateList=new ArrayList<>();

        for (int i = 0; i < spaceLayersTypeList.size(); i++) {
            spaceLayerMemberType = spaceLayersTypeList.get(i).getSpaceLayerMember(); // It gives back  a list.
        }

        for (int j = 0; j < spaceLayerMemberType.size(); j++) {
            spaceLayerTypeList.add(spaceLayerMemberType.get(j).getSpaceLayer());
        }

        for (int n = 0; n < spaceLayerTypeList.size(); n++) {
            for(int m=0; m < spaceLayerTypeList.get(n).getNodes().size(); m++) {
                for (int p=0;p <spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().size();p++) {

                   DirectPositionType directPositionType = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState().getGeometry().getPoint().getPos();
                   Point point=new Point();
                   point.setRealX(directPositionType.getValue().get(0));
                   point.setRealY(directPositionType.getValue().get(1));
                   point.setZ(directPositionType.getValue().get(2));

                   State state =new State();
                   state.setPosition(point);
                   stateList.add(state);
                   }
                }

                stateFloor.setStateMember(stateList);
                stateOnFloor.add(stateFloor);

                Nodes nodes=new Nodes();
                nodes.setStateOnFloors(stateOnFloor);
                nodesList.add(nodes);

                SpaceLayer spaceLayer=new SpaceLayer();
                spaceLayer.setNodes(nodesList);

                spaceLayerList.add(spaceLayer);

                SpaceLayers spaceLayers1=new SpaceLayers();
                spaceLayers1.setSpaceLayerMember(spaceLayerList);

                spaceLayerS.add(spaceLayers1);
            }

            MultiLayeredGraph multiLayeredGraph = new MultiLayeredGraph();
           // multiLayeredGraph.setInterEdges(spaceLayerS);
            multiLayeredGraph.setSpaceLayers(spaceLayerS);
            return multiLayeredGraph;
        }
    }