package han.ica.asd.app.data_structures.non_linear_data_structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public interface IDijkstra {

    enum Weight {
        UNWEIGHTED, WEIGHTED
    }

    void reset();

    /**
     * calculates and returns the shortest path between two vertices.
     * @param vertices all vertices in graph
     * @param start starting point
     * @param finish ending point
     * @param weight determines the type of graph, either UNWEIGHTED or WEIGHTED.
     * @return Path containing the shortest path between vertices start and finish
     */
    default Path getShortestPath(HashMap<String, Vertex> vertices, String start, String finish, Weight weight) {
        final Vertex startVertex = vertices.get(start);
        shortestPathFromVertexToAllOthers(vertices, startVertex, weight);
        final Path shortestPath = createShortestPath(startVertex, vertices.get(finish), weight);
        reset();
        return shortestPath;
    }

    private Path createShortestPath(Vertex start, Vertex finish, Weight weight) {
        final List<Vertex> reversePathList = new ArrayList<>();
        Vertex vertex = finish;
        while (vertex.getPrevious() != null) {
            reversePathList.add(vertex);
            vertex = vertex.getPrevious();
        }
        reversePathList.add(start);
        final List<Vertex> pathVertices = new ArrayList<>();
        IntStream.iterate(reversePathList.size() - 1, i -> i >= 0, i -> i - 1).mapToObj(reversePathList::get).forEach(pathVertices::add);
        return weight == Weight.UNWEIGHTED ? new Path(pathVertices, finish.getDistance(), weight)
                : new Path(pathVertices, reversePathList.size(), finish.getDistance(), weight);
    }


    default void shortestPathFromVertexToAllOthers(HashMap<String, Vertex> vertices, Vertex startVertex, Weight weight) {
        vertices.values().forEach(vertex -> vertex.setDistance(Integer.MAX_VALUE));
        final PriorityQueue<Vertex> pq = new PriorityQueue<>(vertices.size());
        pq.add(startVertex);
        startVertex.setDistance(0);
        if (weight == Weight.UNWEIGHTED)
            shortestPathFromVertexToAllOthersUnweighted(pq);
        else
            shortestPathFromVertexToAllOthersWeighted(pq);
    }

    private void shortestPathFromVertexToAllOthersUnweighted(PriorityQueue<Vertex> pq) {
        while (!pq.isEmpty()) {
            final Vertex vertex = pq.poll();
            vertex.getEdges().forEach(edge -> {
                final Vertex destination = edge.getDestination();
                if (destination.getDistance() == Integer.MAX_VALUE) {
                    destination.setDistance(vertex.getDistance() + 1);
                    destination.setPrevious(vertex);
                    pq.add(destination);
                }
            });
        }
    }

    private void shortestPathFromVertexToAllOthersWeighted(PriorityQueue<Vertex> pq) {
        while (!pq.isEmpty()) {
            final Vertex vertex = pq.poll();
            vertex.getEdges().forEach(edge -> {
                final Vertex destination = edge.getDestination();
                if (destination.getDistance() == Integer.MAX_VALUE) {
                    destination.setDistance(vertex.getDistance() + edge.getWeight());
                    destination.setPrevious(vertex);
                    pq.add(destination);
                } else if (vertex.getDistance() + edge.getWeight() < destination.getDistance()) {
                    destination.setDistance(vertex.getDistance() + edge.getWeight());
                    destination.setPrevious(vertex);
                }
            });
        }
    }
}