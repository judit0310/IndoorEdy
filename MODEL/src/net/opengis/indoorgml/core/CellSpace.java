package net.opengis.indoorgml.core;

import java.io.Serializable;
import java.util.ArrayList;

import net.opengis.indoorgml.geometry.LineString;
import net.opengis.indoorgml.geometry.Polygon;
import net.opengis.indoorgml.geometry.Solid;

public class CellSpace extends AbstractFeature implements Serializable {

	private static final long serialVersionUID = -4034197961145401035L;
	private static int labelNumber = 1;

	private Solid geometry3D;
	private Polygon geometry2D;
	private State duality;
	private String externalReference;
	private ArrayList<CellSpaceBoundary> partialBoundedBy;

	private ArrayList<LineString> lineStringElements;

	// for 3D
    private double ceilingHeight;

	
	public CellSpace() {
		super.setGmlID( "C" + (labelNumber++) );

		setDescription("Usage", "Room");
	}
	
	public CellSpace(CellSpace other) {
		super(other);
		geometry2D = other.geometry2D.clone();
		externalReference = other.externalReference;
		
		ceilingHeight = other.ceilingHeight;
	}
	
	public static int getLabelNumber() {
		return labelNumber;
	}

	public static void setLabelNumber(int labelNumber) {
		CellSpace.labelNumber = labelNumber;
	}

	public Solid getGeometry3D() {
		return geometry3D;
	}

	public void setGeometry3D(Solid geometry3d) {
		geometry3D = geometry3d;
	}

	public Polygon getGeometry2D() {
		return geometry2D;
	}

	public void setGeometry2D(Polygon geometry2d) {
		geometry2D = geometry2d;
	}

	public State getDuality() {
		return duality;
	}

	public void setDuality(State duality) {
		this.duality = duality;
	}

	public ArrayList<CellSpaceBoundary> getPartialBoundedBy() {
		if (partialBoundedBy == null) {
			partialBoundedBy = new ArrayList<CellSpaceBoundary>();
		}
		return partialBoundedBy;
	}

	public void setPartialBoundedBy(ArrayList<CellSpaceBoundary> partialBoundedBy) {
		this.partialBoundedBy = partialBoundedBy;
	}

	public String getExternalReference() {
		return externalReference;
	}

	public void setExternalReference(String externalReference) {
		this.externalReference = externalReference;
	}

	public ArrayList<LineString> getLineStringElements() {
		if (lineStringElements == null) {
			lineStringElements = new ArrayList<LineString>();
		}
		return lineStringElements;
	}

	public void setLineStringElements(ArrayList<LineString> lineStringElements) {
		this.lineStringElements = lineStringElements;
	}

	public double getCeilingHeight() {
            return ceilingHeight;
        }
    
    public void setCeilingHeight(double ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }
}
