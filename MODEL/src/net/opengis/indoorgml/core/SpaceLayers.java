package net.opengis.indoorgml.core;

import java.io.Serializable;
import java.util.ArrayList;


public class SpaceLayers extends AbstractFeature implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4063752783470065682L;
	private static int labelNumber = 1;
	private ArrayList<SpaceLayer> spaceLayerMember;
	
	public SpaceLayers() {
		super.setGmlID( "SL" + (labelNumber++) );
	}
	
	public SpaceLayers(SpaceLayers other) {
		super(other);
	}

	public ArrayList<SpaceLayer> getSpaceLayerMember() {
		if (spaceLayerMember == null) {
			spaceLayerMember = new ArrayList<SpaceLayer>();
			spaceLayerMember.add(new SpaceLayer());
		}
		return spaceLayerMember;
	}
	public void setSpaceLayerMember(ArrayList<SpaceLayer> spaceLayerMember) {
		this.spaceLayerMember = spaceLayerMember;
	}

	public static int getLabelNumber() {
		return labelNumber;
	}

	public static void setLabelNumber(int labelNumber) {
		SpaceLayers.labelNumber = labelNumber;
	}

}