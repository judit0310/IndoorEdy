package net.opengis.indoorgml.iit;

import net.opengis.indoorgml.core.AbstractFeature;
import net.opengis.indoorgml.core.InterEdges;
import net.opengis.indoorgml.core.SpaceLayers;

import java.io.Serializable;
import java.util.ArrayList;

public class MultiLayeredGraph extends AbstractFeature implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -2696458817647102257L;
    private static int labelNumber = 1;
    private ArrayList<SpaceLayers> spaceLayers;
    private ArrayList<InterEdges> interEdges;

    public MultiLayeredGraph() {
        super.setGmlID( "MLG" + (labelNumber++) );
    }

    public MultiLayeredGraph(net.opengis.indoorgml.core.MultiLayeredGraph other) {
        super(other);
    }

    public ArrayList<SpaceLayers> getSpaceLayers() {
        if (spaceLayers == null) {
            spaceLayers = new ArrayList<SpaceLayers>();
            spaceLayers.add(new SpaceLayers());
        }
        return spaceLayers;
    }

    public void setSpaceLayers(ArrayList<SpaceLayers> spaceLayers) {
        this.spaceLayers = spaceLayers;
    }

    public ArrayList<InterEdges> getInterEdges() {
        if(interEdges == null) {
            interEdges = new ArrayList<InterEdges>();
            interEdges.add(new InterEdges());
        }

        return interEdges;
    }

    public void setInterEdges(ArrayList<InterEdges> interEdges) {
        this.interEdges = interEdges;
    }

    public static int getLabelNumber() {
        return labelNumber;
    }

    public static void setLabelNumber(int labelNumber) {
        labelNumber = labelNumber;
    }

}