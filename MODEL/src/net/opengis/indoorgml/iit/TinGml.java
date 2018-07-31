package net.opengis.indoorgml.iit;

import net.opengis.gml.v_3_2_1.TinType;

import java.util.List;

public class TinGml {

    private List<LineStringSegmentArrayPropertyGml> stopLines;
    private List<LineStringSegmentArrayPropertyGml> breakLines;
    protected LengthGml maxLength;
    protected TinType.ControlPoint controlPoint;

    public List<LineStringSegmentArrayPropertyGml> getStopLines() {
        return stopLines;
    }

    public void setStopLines(List<LineStringSegmentArrayPropertyGml> stopLines) {
        this.stopLines = stopLines;
    }

    public List<LineStringSegmentArrayPropertyGml> getBreakLines() {
        return breakLines;
    }

    public void setBreakLines(List<LineStringSegmentArrayPropertyGml> breakLines) {
        this.breakLines = breakLines;
    }

    public LengthGml getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(LengthGml maxLength) {
        this.maxLength = maxLength;
    }

    public TinType.ControlPoint getControlPoint() {
        return controlPoint;
    }

    public void setControlPoint(TinType.ControlPoint controlPoint) {
        this.controlPoint = controlPoint;
    }
}
