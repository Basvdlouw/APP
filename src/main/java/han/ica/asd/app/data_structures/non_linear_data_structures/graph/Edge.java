package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Vertex;

public class Edge  {

    private Vertex destination;
    private int weight;
    private static final int DEFAULT_WEIGHT_VALUE = 0;

    public Edge (Vertex vertex) {
        this.destination = vertex;
        weight = DEFAULT_WEIGHT_VALUE;
    }

    public Edge(Vertex vertex, int weight) {
        this.destination = vertex;
        this.weight =  weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getDestination() {
        return destination;
    }
}
