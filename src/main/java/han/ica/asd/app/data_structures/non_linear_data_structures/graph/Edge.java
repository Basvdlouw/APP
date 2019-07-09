package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

public class Edge  {

    private final Vertex destination;
    private final int weight;
    private static final int DEFAULT_WEIGHT_VALUE = 0;

    public Edge (Vertex vertex) {
        this.destination = vertex;
        weight = DEFAULT_WEIGHT_VALUE;
    }

    public Edge(Vertex vertex, int weight) {
        this.destination = vertex;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getDestination() {
        return destination;
    }
}
