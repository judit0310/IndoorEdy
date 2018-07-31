package net.opengis.indoorgml.core;

import java.io.Serializable;
import java.util.ArrayList;


public class InterEdges extends AbstractFeature implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4120389619785797681L;
	private static int labelNumber = 1;
	private ArrayList<InterLayerConnection> interLayerConnectionMember;
	
	public InterEdges() {
		// TODO Auto-generated constructor stub
		super.setGmlID( "IE" + (labelNumber++) );
	}
	
	public InterEdges(InterEdges other) {
		super(other);
	}

	public ArrayList<InterLayerConnection> getInterLayerConnectionMember() {
		if (interLayerConnectionMember == null) {
			interLayerConnectionMember = new ArrayList<InterLayerConnection>();
		}
		return interLayerConnectionMember;
	}

	public void setInterLayerConnectionMember(
			ArrayList<InterLayerConnection> interLayerConnectionMember) {
		this.interLayerConnectionMember = interLayerConnectionMember;
	}

	public static int getLabelNumber() {
		return labelNumber;
	}

	public static void setLabelNumber(int labelNumber) {
		InterEdges.labelNumber = labelNumber;
	}


}
