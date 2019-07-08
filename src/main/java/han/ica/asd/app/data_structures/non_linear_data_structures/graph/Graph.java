package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Graph {

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

    public Graph() {
        vertices = new HashMap<>();
    }

    public abstract void createGraph(String[][] schema);

    protected void addVerticesToList(String[] strings) {
        if (vertices.get(strings[0]) == null) {
            final Vertex vertex = new Vertex(strings[0]);
            vertices.put(vertex.getName(), vertex);
        }
        if (vertices.get(strings[1]) == null) {
            final Vertex destination = new Vertex(strings[1]);
            vertices.put(destination.getName(), destination);
        }
    }

    public void addVertex(Vertex vertex, Edge edge) {
        //TODO: Implement this method
    }

    public abstract void print();
}

