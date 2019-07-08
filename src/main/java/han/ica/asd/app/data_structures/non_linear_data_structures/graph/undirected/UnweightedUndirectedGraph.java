package han.ica.asd.app.data_structures.non_linear_data_structures.graph.undirected;

import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Edge;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Graph;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Vertex;

import java.util.Arrays;
import java.util.HashMap;

public class UnweightedUndirectedGraph extends Graph {



    public void createGraph(String[][] schema) {
        Arrays.stream(schema).forEach(strings -> {
            addVerticesToList(strings);
            vertices.get(strings[0]).addEdge(new Edge(vertices.get(strings[1])));
            vertices.get(strings[1]).addEdge(new Edge(vertices.get(strings[0])));
        });
    }

    @Override
    public void print() {
        vertices.values().forEach(Vertex::printUnweighted);
    }

    public static void main(String[] args) {
        UnweightedUndirectedGraph unweightedUndirectedGraph = new UnweightedUndirectedGraph();
        unweightedUndirectedGraph.createGraph(DEFAULT_UNWEIGHTED_SCHEMA);
        unweightedUndirectedGraph.print();
    }
}
