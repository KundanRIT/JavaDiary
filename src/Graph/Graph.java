package Graph;

import java.util.HashMap;
import java.util.Set;

public class Graph {
    String id;
    HashMap<String, Vertex> vertices;

    public Graph(String id) {
        this.id = id;
        vertices = new HashMap<>();
    }

    public void addEdge(String src, String dst, int weight) {
        if (!vertices.containsKey(src))
            vertices.put(src, new Vertex(src));

        if (!vertices.containsKey(dst))
            vertices.put(dst, new Vertex(dst));

        vertices.get(src).addConnection(dst, weight);
        vertices.get(dst).addConnection(src, weight);
    }

    public Set<String> getVertices() {
        return vertices.keySet();
    }

    public Vertex getVertex(String id) {
        return vertices.getOrDefault(id, null);
    }
}
