package hu.iit.uni.miskolc.hu.daoxml;

import net.opengis.gml.v_3_2_1.*;
import net.opengis.indoorgml.core.*;
import net.opengis.indoorgml.core.v_1_0.*;
import net.opengis.indoorgml.geometry.LineString;
import net.opengis.indoorgml.geometry.Point;
import net.opengis.indoorgml.iit.DirectPosition;
import net.opengis.indoorgml.iit.Edges;
import net.opengis.indoorgml.iit.MultiLayeredGraph;
import net.opengis.indoorgml.iit.Nodes;
import net.opengis.indoorgml.iit.SpaceLayer;

import java.util.ArrayList;
import java.util.List;

public class MapperNavigation {

    private List<SpaceLayerType> spaceLayerTypeList;
    private ArrayList<State> stateArrayList;
    private ArrayList<Transition> transitionArrayList;
    private ArrayList<Transition> transitionList;
    private ArrayList<State> stateList;
    private ArrayList<StateType> stateTypeArrayList;
    private ArrayList<Point> pointArrayList=new ArrayList<>();

    public MultiLayeredGraph multiLayeredGraphMapper(MultiLayeredGraphPropertyType multiLayeredGraphPropertyType) {

        spaceLayerTypeList = new ArrayList<>();
        stateArrayList=new ArrayList<>();
        stateList = new ArrayList<>();
        transitionArrayList=new ArrayList<>();
        transitionList = new ArrayList<>();
        stateTypeArrayList = new ArrayList<>();

        List<SpaceLayersType> spaceLayersTypeList = multiLayeredGraphPropertyType.getMultiLayeredGraph().getSpaceLayers();
        List<SpaceLayerMemberType> spaceLayerMemberType = new ArrayList<>();
        ArrayList<SpaceLayer> spaceLayerList = new ArrayList<>();
        ArrayList<SpaceLayers> spaceLayerS = new ArrayList<>();
        List<Nodes> nodesList = new ArrayList<>();
        ArrayList<StateOnFloor> stateOnFloor = new ArrayList<>();
        StateOnFloor stateFloor = new StateOnFloor();
        ArrayList<Edges> edgesList = new ArrayList<>();

        for (int i = 0; i < spaceLayersTypeList.size(); i++) {
            spaceLayerMemberType = spaceLayersTypeList.get(i).getSpaceLayerMember(); // It gives back  a list.
        }

        for (int j = 0; j < spaceLayerMemberType.size(); j++) {
            spaceLayerTypeList.add(spaceLayerMemberType.get(j).getSpaceLayer());
        }

        readUpStateList();
        readUpTransitionList();

        stateFloor.setStateMember(stateList);
        stateOnFloor.add(stateFloor);

        Nodes nodes = new Nodes();
        nodes.setStateOnFloors(stateOnFloor);
        nodesList.add(nodes);

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

        SpaceLayers spaceLayers1 = new SpaceLayers();
        spaceLayers1.setSpaceLayerMember(spaceLayerList);
        spaceLayerS.add(spaceLayers1);

        MultiLayeredGraph multiLayeredGraph = new MultiLayeredGraph();
        InterEdges interEdges=new InterEdges();

        multiLayeredGraph.setSpaceLayers(spaceLayerS);
        return multiLayeredGraph;
    }

    private void readUpStateList() {
        for (int n = 0; n < spaceLayerTypeList.size(); n++) {
            for (int m = 0; m < spaceLayerTypeList.get(n).getNodes().size(); m++) {
                for (int p = 0; p < spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().size(); p++) {

                    DirectPositionType directPositionType = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState().getGeometry().getPoint().getPos();
                    List<TransitionPropertyType> transitionPropertyTypeList = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState().getConnects();
                    StateType stateType = spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().get(p).getState();

                    stateTypeArrayList.add(stateType);
                    stateArrayList.add(stateCreator(stateType));

                    System.out.println("-->"+ spaceLayerTypeList.get(n).getNodes().get(m).getStateMember().size() +" "+
                    spaceLayerTypeList.get(n).getNodes().size() + " "+
                    spaceLayerTypeList.size());
                }
            }
        }
    }

    public void readUpTransitionList() {
        for (int n = 0; n < spaceLayerTypeList.size(); n++) {
            for (int m = 0; m < spaceLayerTypeList.get(n).getEdges().size(); m++) {
                for (int q = 0; q < spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().size(); q++) {
                    for (int r = 0; r < spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(q).getTransition().getConnects().size(); r++) {

                        TransitionType t1 = spaceLayerTypeList.get(n).getEdges().get(m).getTransitionMember().get(q).getTransition();
                        //TransitionType has got no values in connects/State

                        StateType[] stateTypeArray = new StateType[2];
                        stateTypeArray[0] = getStateTypeByHref(t1.getConnects().get(0).getHref());;
                        stateTypeArray[1] = getStateTypeByHref(t1.getConnects().get(1).getHref());;

                        List<StatePropertyType> statePropertyTypes = new ArrayList<>();
                        StatePropertyType statePropertyType=new StatePropertyType();
                        StatePropertyType statePropertyType2=new StatePropertyType();

                        statePropertyType.setState(stateTypeArray[0]);
                        statePropertyTypes.add(statePropertyType);

                        statePropertyType2.setState(stateTypeArray[1]);
                        statePropertyTypes.add(statePropertyType2);

                        t1.setConnects(statePropertyTypes);

                        Transition transition = transitionCreator(t1);
                        transitionList.add(transition);
                    }
                }
            }
        }
    }

    private StateType getStateTypeByHref(String Href) {
        StateType stateType=new StateType();
        //System.out.println(stateArrayList.get(i).getGmlID());
        for(int i=0;i<stateTypeArrayList.size();i++){
            if((stateTypeArrayList.get(i).getId().matches(Href.substring(1)))){
                stateType=stateTypeArrayList.get(i);
                break;
            }
        }
        return stateType;
    }

    //Href and GmlID is equal to each other.
    public State getStateByHref(String Href){
        State state=new State();
        //System.out.println(stateArrayList.get(i).getGmlID());
        for(int i=0;i<stateArrayList.size();i++){
            if((stateArrayList.get(i).getGmlID().matches(Href.substring(1)))){
                state=stateArrayList.get(i);
            }
            break;
        }
        return state;
    }

    public State stateCreator(StateType stateType) {
        PointPropertyType pointPropertyType = stateType.getGeometry();
        State state = new State();
        state.setPosition(pointCreator(pointPropertyType.getPoint()));
        state.setGmlID(stateType.getId());
        return state;
    }

    public Point pointCreator(PointType pointType){
        DirectPositionType directPositionType = pointType.getPos();
        List<Double> list = directPositionType.getValue();

        Point point=new Point();
        point.setGMLID(pointType.getId());

        point.setRealX(list.get(0));
        point.setRealY(list.get(1));
        point.setZ(list.get(2));

        pointArrayList.add(point);
        return point;
    }

    public Transition transitionCreator(TransitionType transitionType){
        Transition transition = new Transition();

       // StateType stateType = getStateTypeByHref(transitionType.getConnects().get(0).getState().getHref());
       // StateType stateType2 = getStateTypeByHref(transitionType.getConnects().get(1).getState().getHref());

        //transitionType.getConnects().


        State[] statesOfTransition = new State[2];
        statesOfTransition[0] = stateCreator(transitionType.getConnects().get(0).getState());
        statesOfTransition[1] = stateCreator(transitionType.getConnects().get(1).getState());

        AbstractCurveType abstractCurveType = (AbstractCurveType)transitionType.getGeometry().getAbstractCurve().getValue();
        LineStringType lineStringType = (LineStringType) abstractCurveType;
        LineString path = new LineString();


        transition.setStates(statesOfTransition);
        transition.setGmlID(transitionType.getId());
        transition.setWeight(transitionType.getWeight());

        return transition;
    }


    public ArrayList<SpaceLayers> SpaceLayerCreator(SpaceLayersType spaceLayersType) {
        List <SpaceLayerMemberType> spaceLayerMemberTypeList = spaceLayersType.getSpaceLayerMember();
        for(int i=0; i<spaceLayerMemberTypeList.size(); i++){

        }
    ArrayList<SpaceLayers> spaceLayers=new ArrayList<SpaceLayers>();
    return spaceLayers;
    }

    public Transition getTransitionByHref(String Href){
        Transition transition=new Transition();

        return transition;
    }

    public LineString LineStringCreator(LineStringType lineStringType){
        LineString lineString=new LineString();
        for(int i=0; i< lineStringType.getPosOrPointPropertyOrPointRep().size();i++){
            DirectPositionType directPositionType = (DirectPositionType) lineStringType.getPosOrPointPropertyOrPointRep().get(i).getValue();
        }
        return lineString;
    }

    public DirectPosition directPositionCreator(DirectPositionType directPositionType){
        DirectPosition directPosition=new DirectPosition((ArrayList<Double>) directPositionType.getValue());
        return directPosition;
    }
}