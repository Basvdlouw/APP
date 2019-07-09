package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private List<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void printUnweighted() {
        edges.stream().map(edge -> name + " -> " + edge.getDestination().getName()).forEach(System.out::println);
    }

    public void printWeighted() {
        edges.stream().map(edge -> name + " -> " + edge.getDestination().getName() + " with a weight of " + edge.getWeight()).forEach(System.out::println);
    }
}
