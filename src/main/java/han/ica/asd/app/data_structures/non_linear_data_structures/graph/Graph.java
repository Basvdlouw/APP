package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Graph implements IDijkstra{

    public static final String[][] DEFAULT_UNWEIGHTED_SCHEMA = {
            {"V1", "V2"},
            {"V1", "V3"},
            {"V3", "V4"},
            {"V4", "V2"},
            {"V4", "V5"},
            {"V5", "V6"},
    };

    public static final String[][] DEFAULT_WEIGHTED_SCHEMA = {
            {"V1", "V2", "12"},
            {"V1", "V3", "-2"},
            {"V3", "V4", "14"},
            {"V4", "V2", "9"},
            {"V4", "V5", "1"},
            {"V5", "V6", "10"},
    };

    /**
     * Maps a vertex to it's name. this is done in order to create a graph more easily.
     */
    protected final HashMap<String, Vertex> vertices;

    public abstract void print();

    public abstract void createGraph(String[][] schema);

    public Graph() {
        vertices = new HashMap<>();
    }

    /**
     * This method assumes that the vertices added will have their edges defined later
     * @param strings converts strings[] to two vertices
     */
    public void addVerticesToList(String[] strings) {
        vertices.putIfAbsent(strings[0], new Vertex(strings[0]));
        vertices.putIfAbsent(strings[1], new Vertex(strings[1]));
    }


    public void reset() {
        vertices.values().forEach(v -> v.reset());
    }
    /**
     * This method assumes that the vertices added already have their edges defined
     *
     * @param vertex
     * @param destination
     */
    public void addVertex(Vertex vertex, Vertex destination) {
        vertices.putIfAbsent(vertex.getName(), vertex);
        vertices.putIfAbsent(destination.getName(), destination);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        AtomicInteger index = new AtomicInteger();
        vertices.values().forEach(vertex -> {
            stringBuilder.append("Vertex: ").append(vertex.getName()).append(" has the following edges ");
            vertex.getEdges().stream().filter(Objects::nonNull)
                    .forEach(e ->
                    {
                        final int size = vertex.getEdges().size();
                        stringBuilder.append(e.getDestination().getName()).append(index.incrementAndGet() < size ? ", " : "");
                        if (index.get() == size)
                            index.set(0);
                    });
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }
}

