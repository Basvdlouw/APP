package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Graph implements IDijkstra {

    public static final String[][] DEFAULT_UNWEIGHTED_SCHEMA = {
        {"V0", "V1"},
        {"V0", "V3"},
        {"V1", "V3"},
        {"V1", "V4"},
        {"V2", "V0"},
        {"V2", "V5"},
        {"V3", "V2"},
        {"V3", "V4"},
        {"V3", "V5"},
        {"V3", "V6"},
        {"V4", "V6"},
        {"V6", "V5"}
    };

    public static final String[][] DEFAULT_WEIGHTED_SCHEMA = {
        {"V0", "V1", "2"},
        {"V0", "V3", "1"},
        {"V1", "V3", "3"},
        {"V1", "V4", "10"},
        {"V2", "V0", "4"},
        {"V2", "V5", "5"},
        {"V3", "V2", "2"},
        {"V3", "V4", "2"},
        {"V3", "V5", "8"},
        {"V3", "V6", "4"},
        {"V4", "V6", "6"},
        {"V6", "V5", "1"}
    };

    /**
     * Maps a vertex to it's name. this is done in order to create a graph more easily.
     */
    protected final HashMap<String, Vertex> vertices;

    protected final Weight weighted;

    public abstract void print();

    public abstract void createGraph(String[][] schema);

    public Graph(Weight weighted) {
        vertices = new HashMap<>();
        this.weighted = weighted;
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
        vertices.values().forEach(Vertex::reset);
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

    public boolean isConnected() {
        reset();
        shortestPathFromVertexToAllOthers(vertices, (Vertex) vertices.values().toArray()[1], weighted);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        vertices.values().stream().filter(vertex -> vertex.getDistance() == Integer.MAX_VALUE).map(vertex -> false).forEach(atomicBoolean::set);
        reset();
        return atomicBoolean.get();
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

