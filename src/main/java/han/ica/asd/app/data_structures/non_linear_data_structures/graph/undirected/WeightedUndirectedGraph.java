package han.ica.asd.app.data_structures.non_linear_data_structures.graph.undirected;

import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Edge;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Graph;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Vertex;

import java.util.Arrays;

public class WeightedUndirectedGraph extends Graph {

    public void createGraph(String[][] schema) {
        Arrays.stream(schema).forEach(strings -> {
            addVerticesToList(strings);
            int weight = Integer.parseInt(strings[2]);
            vertices.get(strings[0]).addEdge(new Edge(vertices.get(strings[1]), weight));
            vertices.get(strings[1]).addEdge(new Edge(vertices.get(strings[0]), weight));
        });
    }

    @Override
    public void print() {
        vertices.values().forEach(Vertex::printWeighted);
    }

    public static void main(String[] args) {
        WeightedUndirectedGraph weightedUndirectedGraph = new WeightedUndirectedGraph();
        weightedUndirectedGraph.createGraph(DEFAULT_WEIGHTED_SCHEMA);
        weightedUndirectedGraph.print();
    }
}
