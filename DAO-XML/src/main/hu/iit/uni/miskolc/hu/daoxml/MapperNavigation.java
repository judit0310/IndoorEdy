package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.gml.v_3_2_1.AbstractCurveType;
import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.indoorgml.core.*;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.geometry.Point;
import net.opengis.indoorgml.iit.Edges;
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
        ArrayList<Edges> edgesList=new ArrayList<>();
        ArrayList<Transition> transitionList = new ArrayList<>();

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

                   AbstractCurveType abstractCurveType =  spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(p).getTransition().getGeometry().getAbstractCurve().getValue();

                   State[] stateArray=new State[2];
                   for(int r=0;r<spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(p).getTransition().getConnects().size();r++) {
                       Point point=new Point();
                       List<Double> pointcoordinates=new ArrayList<>();


                       spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(p).getTransition().getConnects().get(0).getHref();
                       //Have to write a method to search State by href


                       point.setRealX(pointcoordinates.get(0));
                       point.setRealY(pointcoordinates.get(1));
                       point.setZ(pointcoordinates.get(2));
                       State state=new State();
                       state.setPosition(point);
                       stateArray[r]=state;
                   }


                   Point point=new Point();
                   point.setRealX(directPositionType.getValue().get(0));
                   point.setRealY(directPositionType.getValue().get(1));
                   point.setZ(directPositionType.getValue().get(2));

                   State state =new State();
                   state.setPosition(point);
                   stateList.add(state);

                   /////////////////////////////////////////////////

                   Transition transition=new Transition();
                   transition.setWeight(spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(p).getTransition().getWeight());
                   transition.setStates(stateArray);
                   transitionList.add(transition);

                   }
                }


                stateFloor.setStateMember(stateList);
                stateOnFloor.add(stateFloor);

                Nodes nodes=new Nodes();
                nodes.setStateOnFloors(stateOnFloor);
                nodesList.add(nodes);

                /////////////////////////

                Edges edges=new Edges();
                ArrayList<TransitionOnFloor> transitionOnFLoor=new ArrayList<>();
                edges.setTransitionOnFloors(transitionOnFLoor);
                edgesList.add(edges);

                SpaceLayer spaceLayer=new SpaceLayer();
                spaceLayer.setNodes(nodesList);
                spaceLayer.setEdges(edgesList);

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