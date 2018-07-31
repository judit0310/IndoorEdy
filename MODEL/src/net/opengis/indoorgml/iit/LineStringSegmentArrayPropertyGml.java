package net.opengis.indoorgml.iit;

import java.util.List;

public class LineStringSegmentArrayPropertyGml {
    private List<LineStringSegment> lineStringSegment;

    public LineStringSegmentArrayPropertyGml(List<LineStringSegment> lineStringSegment) {
        this.lineStringSegment = lineStringSegment;
    }

    public List<LineStringSegment> getLineStringSegment() {
        return lineStringSegment;
    }

    public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
        this.lineStringSegment = lineStringSegment;
    }
}