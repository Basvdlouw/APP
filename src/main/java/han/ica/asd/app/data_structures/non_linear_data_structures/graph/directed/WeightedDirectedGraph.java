package han.ica.asd.app.data_structures.non_linear_data_structures.graph.directed;

import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Edge;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Graph;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Vertex;

import java.util.Arrays;

public class WeightedDirectedGraph extends Graph {

    public WeightedDirectedGraph(String[][] schema) {
        super(Weight.WEIGHTED);
        createGraph(schema);
    }

    public WeightedDirectedGraph() {
        super(Weight.WEIGHTED);
    }

    @Override
    public void createGraph(String[][] schema) {
        Arrays.stream(schema).forEach(strings -> {
            addVerticesToList(strings);
            vertices.get(strings[0]).addEdge(new Edge(vertices.get(strings[1]), Integer.parseInt(strings[2])));
        });
    }

    @Override
    public void print() {
        vertices.values().forEach(Vertex::printWeighted);
    }

    public static void main(String[] args) {
        final WeightedDirectedGraph weightedDirectedGraph = new WeightedDirectedGraph(DEFAULT_WEIGHTED_SCHEMA);
        weightedDirectedGraph.print();
        weightedDirectedGraph.getShortestPath(weightedDirectedGraph.vertices, "V0", "V5", weightedDirectedGraph.weighted).print();
        System.out.println("Connected : " + weightedDirectedGraph.isConnected());
    }
}
