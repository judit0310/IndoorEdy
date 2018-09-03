package net.opengis.indoorgml.iit;

import net.opengis.indoorgml.core.AbstractFeature;
import net.opengis.indoorgml.iit.Edges;
import net.opengis.indoorgml.iit.Nodes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SpaceLayer extends AbstractFeature implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7497272085077190859L;
	private static int labelNumber = 1;
	private List<Nodes> nodes;
	private ArrayList<Edges> edges;

	public SpaceLayer() {
		super.setGmlID( "IS" + (labelNumber++) );
	}
	
	public SpaceLayer(SpaceLayer other) {
		super(other);
	}

	public List<Nodes> getNodes() {
		if (nodes == null) {
			nodes = new ArrayList<Nodes>();
			nodes.add(new Nodes());
		}
		return nodes;
	}

	public void setNodes(List<net.opengis.indoorgml.iit.Nodes> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<Edges> getEdges() {
		if(edges == null) {
			edges = new ArrayList<Edges>();
			edges.add(new Edges());
		}
		return edges;
	}

	public void setEdges(ArrayList<Edges> edges) {
		this.edges = edges;
	}

	public static int getLabelNumber() {
		return labelNumber;
	}

	public static void setLabelNumber(int labelNumber) {
		SpaceLayer.labelNumber = labelNumber;
	}

}