package net.opengis.indoorgml.iit;

import net.opengis.gml.v_3_2_1.AggregationType;
import net.opengis.gml.v_3_2_1.CurvePropertyType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class RingGml {

    private List<CurveGml> curveMember;
    private AggregationGml aggregationType;

    public RingGml(List<CurveGml> curveMember, AggregationGml aggregationType) {
        this.curveMember = curveMember;
        this.aggregationType = aggregationType;
    }

    public List<CurveGml> getCurveMember() {
        return curveMember;
    }

    public void setCurveMember(List<CurveGml> curveMember) {
        this.curveMember = curveMember;
    }

    public AggregationGml getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(AggregationGml aggregationType) {
        this.aggregationType = aggregationType;
    }
}
