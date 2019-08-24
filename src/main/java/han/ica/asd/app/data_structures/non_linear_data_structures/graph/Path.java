package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import han.ica.asd.app.data_structures.non_linear_data_structures.graph.IDijkstra.Weight;

public class Path {

    private final List<Vertex> vertices;
    private int weight;
    private int steps;
    private Weight weighted;

    public Path(List<Vertex> vertices, int steps, int weight, Weight weighted) {
        this.vertices = vertices;
        this.steps = steps;
        this.weight = weight;
        this.weighted = weighted == null ? Weight.UNWEIGHTED : weighted;
    }

    public Path(List<Vertex> vertices, int steps, Weight weighted) {
        this.vertices = vertices;
        this.steps = steps;
        this.weighted = weighted == null ? Weight.UNWEIGHTED : weighted;
    }

    private void printUnweightedPath(StringBuilder sb) {
      sb.append(" takes ")
        .append(steps)
        .append(" steps");
    }

    private void printWeightedPath(StringBuilder sb) {
        sb.append(" and has a weight of ")
        .append(weight);
    }

    public void print() {
        final StringBuilder sb = new StringBuilder();
        sb.append("The shortest path between ")
        .append(vertices.get(0).getName())
        .append(" and ")
        .append(vertices.get(vertices.size()-1).getName());
        printUnweightedPath(sb);
        if (weighted == Weight.WEIGHTED)
            printWeightedPath(sb);
        sb.append("\n");
        final AtomicInteger index = new AtomicInteger();
        vertices.forEach(vertex -> {
            final int size = vertices.size();
            sb.append(vertex.getName());
            sb.append(index.incrementAndGet() < size ? " -> " : "");
            if (index.get() == size)
                index.set(0);
        });
        System.out.println(sb.toString());
    }
}
