package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.HashSet;

public class Vertex {

    private String name;
    private HashSet<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new HashSet<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public String getName() {
        return name;
    }

    public void printUnweighted() {
        edges.stream().map(edge -> name + " -> " + edge.getDestination().getName()).forEach(System.out::println);
    }

    public void printWeighted() {
        edges.stream().map(edge -> name + " -> " + edge.getDestination().getName() + " with a weight of " + edge.getWeight()).forEach(System.out::println);
    }
}
