package net.opengis.indoorgml.iit;

public class IndoorFeatures {

    public IndoorFeatures(){}

    public IndoorFeatures(PrimalSpaceFeatures primalSpaceFeatures, MultiLayeredGraph multiLayeredGraph) {
        this.primalSpaceFeatures = primalSpaceFeatures;
        this.multiLayeredGraph = multiLayeredGraph;
    }

    public PrimalSpaceFeatures getPrimalSpaceFeatures() {
        return primalSpaceFeatures;
    }

    public void setPrimalSpaceFeatures(PrimalSpaceFeatures primalSpaceFeatures) {
        this.primalSpaceFeatures = primalSpaceFeatures;
    }

    public MultiLayeredGraph getMultiLayeredGraph() {
        return multiLayeredGraph;
    }

    public void setMultiLayeredGraph(MultiLayeredGraph multiLayeredGraph) {
        this.multiLayeredGraph = multiLayeredGraph;
    }

    private PrimalSpaceFeatures primalSpaceFeatures;
    private MultiLayeredGraph multiLayeredGraph;
}