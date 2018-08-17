package net.opengis.indoorgml.iit;

import net.opengis.indoorgml.core.AbstractFeature;
import net.opengis.indoorgml.core.TransitionOnFloor;

import java.io.Serializable;
import java.util.ArrayList;

public class Edges extends AbstractFeature implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6296215029048969109L;
	private static int labelNumber = 1;
	private ArrayList<TransitionOnFloor> transitionOnFloors;
	
	public Edges() {
		super.setGmlID( "E" + (labelNumber++) );
	}
	
	public Edges(Edges other) {
		super(other);
	}

	public ArrayList<TransitionOnFloor> getTransitionOnFloors() {
		if (transitionOnFloors == null) {
			transitionOnFloors = new ArrayList<TransitionOnFloor>();
		}
		return transitionOnFloors;
	}

	public void setTransitionOnFloors(ArrayList<TransitionOnFloor> transitionOnFloor) {
		this.transitionOnFloors = transitionOnFloor;
	}

	public static int getLabelNumber() {
		return labelNumber;
	}

	public static void setLabelNumber(int labelNumber) {
		Edges.labelNumber = labelNumber;
	}

}