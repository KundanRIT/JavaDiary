package Graph;

import java.util.HashMap;
import java.util.Set;

public class Vertex {
    String id;
    HashMap<String, Integer> connections;

    public Vertex(String id) {
        this.id = id;
        connections = new HashMap<>();
    }

    public void addConnection(String connection, int weight) {
        connections.put(connection, weight);
    }

    public int getWeight(String connection) {
        return connections.getOrDefault(connection, null);
    }

    public Set<String> getConnections() {
        return connections.keySet();
    }
}
