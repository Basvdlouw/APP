package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Path {

    private List<Vertex> vertices;
    private int weight;
    private int steps;

    public Path(List<Vertex> vertices, int steps, int weight) {
        this.vertices = vertices;
        this.steps = steps;
        this.weight = weight;
    }

    public Path(List<Vertex> vertices, int steps) {
        this.vertices = vertices;
        this.steps = steps;
    }

    public void printUnweightedPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("From ")
                .append(vertices.get(0).getName())
                .append( " to ")
                .append(vertices.get(vertices.size()-1).getName())
                .append(" takes ")
                .append(steps)
                .append(" steps")
                .append("\n");

        AtomicInteger index = new AtomicInteger();
        vertices.forEach(vertex -> {
            final int size = vertices.size();
            sb.append(vertex.getName());
            sb.append(index.incrementAndGet() < size ?  " -> " : "");
            if (index.get() == size)
                index.set(0);
        });
        System.out.println(sb.toString());
    }

    public void printWeighted() {
        //TODO:Implement this method
    }
}

