package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.gml.v_3_2_1.DirectPositionType;
import net.opengis.gml.v_3_2_1.PointPropertyType;
import net.opengis.gml.v_3_2_1.PointType;
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

    private List<SpaceLayerType> spaceLayerTypeList;
    private ArrayList<State> stateArrayList;

    public MultiLayeredGraph multiLayeredGraphMapper(MultiLayeredGraphPropertyType multiLayeredGraphPropertyType) {

        List<SpaceLayersType> spaceLayersTypeList = multiLayeredGraphPropertyType.getMultiLayeredGraph().getSpaceLayers();

        List<SpaceLayerMemberType> spaceLayerMemberType = new ArrayList<>();
        spaceLayerTypeList = new ArrayList<>();
        stateArrayList=new ArrayList<>();
        ArrayList<SpaceLayer> spaceLayerList = new ArrayList<>();
        ArrayList<SpaceLayers> spaceLayerS = new ArrayList<>();
        List<Nodes> nodesList = new ArrayList<>();
        ArrayList<StateOnFloor> stateOnFloor = new ArrayList<>();
        StateOnFloor stateFloor = new StateOnFloor();
        ArrayList<State> stateList = new ArrayList<>();
        ArrayList<Edges> edgesList = new ArrayList<>();
        ArrayList<Transition> transitionList = new ArrayList<>();

        for (int i = 0; i < spaceLayersTypeList.size(); i++) {
            spaceLayerMemberType = spaceLayersTypeList.get(i).getSpaceLayerMember(); // It gives back  a list.
        }

        for (int j = 0; j < spaceLayerMemberType.size(); j++) {
            spaceLayerTypeList.add(spaceLayerMemberType.get(j).getSpaceLayer());
        }

        for (int n = 0; n < spaceLayerTypeList.size(); n++) {

            for (int m = 0; m < spaceLayerTypeList.get(n).getNodes().size(); m++) {
                for (int p = 0; p < spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().size(); p++) {


                    // AbstractCurveType abstractCurveType = spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(p).getTransition().getGeometry().getAbstractCurve().getValue();
                    DirectPositionType directPositionType = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState().getGeometry().getPoint().getPos();


                    List<TransitionPropertyType> transitionPropertyTypeList = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState().getConnects();

                    StateType stateType = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState();

                    stateArrayList.add(stateCreator(spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState()));

                    for(int s=0;s<transitionPropertyTypeList.size();s++){
                        Transition transition=new Transition();

                        System.out.println(transitionPropertyTypeList.size());

                        List<StatePropertyType> statePropertyTypes = transitionPropertyTypeList.get(s).getTransition().getConnects();

                        State[] states=new State[2];

                        states[0]= stateCreator(statePropertyTypes.get(0).getState());
                        states[1]= stateCreator(statePropertyTypes.get(1).getState());

                        transition.setStates(states);
                        transition.setWeight(1.0);
                        transition.setPath(transitionList.get(s).getPath());
                        transition.setDuality(transitionList.get(s).getDuality());
                    }


                    Point point = new Point();
                    point.setRealX(directPositionType.getValue().get(0));
                    point.setRealY(directPositionType.getValue().get(1));

                    //System.out.println(directPositionType.getValue().get(0));
                    //System.out.println(directPositionType.getValue().get(1));

                    point.setZ(directPositionType.getValue().get(2));


                    State state = new State();
                    state.setPosition(point);
                    state.setTransitions(transitionList);
                    stateList.add(state);
                }
            }




            for (int m = 0; m < spaceLayerTypeList.get(n).getEdges().size(); m++) {
                for (int q = 0; q < spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().size(); q++) {
                    for (int r = 0; r < spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(q).getTransition().getConnects().size(); r++) {


                        TransitionType t1 = spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(q).getTransition();
                        String Href1=t1.getConnects().get(0).getHref();
                        String Href2=t1.getConnects().get(1).getHref();

                        //Have to write a method to search State by href

                        State[] stateArray = new State[2];
                        stateArray[0]= getStateByHref(Href1);;
                        stateArray[1]= getStateByHref(Href2);;


                        Transition transition = new Transition();

                        transition.setWeight(spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(q).getTransition().getWeight());
                        transition.setStates(stateArray);

                        transitionList.add(transition);
                    }
                }
            }

            stateFloor.setStateMember(stateList);
            stateOnFloor.add(stateFloor);

            Nodes nodes = new Nodes();
            nodes.setStateOnFloors(stateOnFloor);
            nodesList.add(nodes);

            /////////////////////////

            TransitionOnFloor transitionOnFloor=new TransitionOnFloor();
            transitionOnFloor.setTransitionMember(transitionList);
            ArrayList<TransitionOnFloor> transitionOnFloorArray = new ArrayList<>();

            transitionOnFloorArray.add(transitionOnFloor);


            Edges edges = new Edges();
            edges.setTransitionOnFloors(transitionOnFloorArray);
            edgesList.add(edges);

            SpaceLayer spaceLayer = new SpaceLayer();
            spaceLayer.setNodes(nodesList);
            spaceLayer.setEdges(edgesList);

            spaceLayerList.add(spaceLayer);

        }

        SpaceLayers spaceLayers1 = new SpaceLayers();
        spaceLayers1.setSpaceLayerMember(spaceLayerList);
        spaceLayerS.add(spaceLayers1);

        MultiLayeredGraph multiLayeredGraph = new MultiLayeredGraph();
        InterEdges interEdges=new InterEdges();

        multiLayeredGraph.setSpaceLayers(spaceLayerS);
        return multiLayeredGraph;
    }

    public State searchStatebyHref(String Href, MultiLayeredGraphPropertyType multiLayeredGraphPropertyType ) {
        MapperCore mapperCore=new MapperCore();
        //IndoorFeatures indoorFeatures=mapperCore.indoorFeaturesCreator();
        return null;
    }


    public State stateCreator(StateType stateType) {
        PointPropertyType pointPropertyType = stateType.getGeometry();
        State state=new State();
        state.setPosition(pointCreator(pointPropertyType.getPoint()));
        state.setGmlID(stateType.getId());
        return state;
    }

    public Point pointCreator(PointType pointType){
        DirectPositionType directPositionType = pointType.getPos();
        List<Double> list = directPositionType.getValue();

        Point point=new Point();
        point.setRealY(list.get(0));
        point.setRealX(list.get(1));
        point.setZ(list.get(2));
        return point;
    }

    public ArrayList<SpaceLayers> SpaceLayerCreator(SpaceLayersType spaceLayersType) {
        List <SpaceLayerMemberType> spaceLayerMemberTypeList = spaceLayersType.getSpaceLayerMember();
        for(int i=0; i<spaceLayerMemberTypeList.size(); i++){

        }
    ArrayList<SpaceLayers> spaceLayers=new ArrayList<SpaceLayers>();
    return spaceLayers;
    }

    //Href and GmlID is equal to each other.
    public State getStateByHref(String Href){
        State state=new State();
        for(int i=0;i<stateArrayList.size();i++){
            if(stateArrayList.get(i).getGmlID().contentEquals(Href)){
                state=stateArrayList.get(i);
                break;
            }
        }
    return state;
    }
}