package net.opengis.indoorgml.core;

import java.io.Serializable;

public class IndoorFeatures extends AbstractFeature implements Serializable{

	private static final long serialVersionUID = 7930354876372409593L;
	private PrimalSpaceFeatures primalSpaceFeatures;
	private MultiLayeredGraph multiLayeredGraph;
	
	public IndoorFeatures() {
	        super.setGmlID( "IFs" );
	}
	
	public IndoorFeatures(IndoorFeatures other) {
		super(other);
	}

	public PrimalSpaceFeatures getPrimalSpaceFeatures() {
		if(primalSpaceFeatures == null) {
			primalSpaceFeatures = new PrimalSpaceFeatures();
		}
		return primalSpaceFeatures;
	}

	public void setPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
		this.primalSpaceFeatures = primalSpaceFeatures;
	}

	public MultiLayeredGraph getMultiLayeredGraph() {
		if(multiLayeredGraph == null) {
			multiLayeredGraph = new MultiLayeredGraph();
		}
		return multiLayeredGraph;
	}

	public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
		this.multiLayeredGraph = multiLayeredGraph;
	}
}
