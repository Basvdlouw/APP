package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private final static int DEFAULT_DISTANCE = 0;

    private String name;
    private List<Edge> edges;
    private int distance;
    private Vertex previous;

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void printUnweighted() {
        edges.stream().map(edge -> name + " -> " + edge.getDestination().getName()).forEach(System.out::println);
    }

    public void printWeighted() {
        edges.stream().map(edge -> name + " -> " + edge.getDestination().getName() + " with a weight of " + edge.getWeight()).forEach(System.out::println);
    }

    @Override
    public int compareTo(Vertex v) {
        return Integer.compare(this.distance, v.distance);
    }

    public int getDistance() {
        return  distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void reset() {
        distance = DEFAULT_DISTANCE;
        previous = null;
    }
}
