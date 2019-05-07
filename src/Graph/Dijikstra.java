package Graph;

import java.util.*;

public class Dijikstra {
    public static void main(String[] args) {
        Graph g = new Graph("graph");
        g.addEdge("0", "1", 4);
        g.addEdge("0", "7", 8);
        g.addEdge("1", "7", 11);
        g.addEdge("1", "2", 8);
        g.addEdge("7", "6", 1);
        g.addEdge("2", "8", 2);
        g.addEdge("6", "8", 6);
        g.addEdge("7", "8", 7);
        g.addEdge("2", "3", 7);
        g.addEdge("3", "5", 14);
        g.addEdge("2", "5", 4);
        g.addEdge("6", "5", 2);
        g.addEdge("3", "4", 9);
        g.addEdge("5", "4", 10);
//        g.addEdge("A", "B", 7);
//        g.addEdge("A", "E", 14);
//        g.addEdge("A", "F", 9);
//        g.addEdge("E", "F", 2);
//        g.addEdge("B", "F", 8);
//        g.addEdge("E", "D", 9);
//        g.addEdge("B", "C", 15);
//        g.addEdge("F", "C", 6);
//        g.addEdge("D", "C", 4);
        int size = g.vertices.size();

        String start = "0";
        int infinity = Integer.MAX_VALUE;

        Set<String> visited = new HashSet<>();
        HashMap<String, Integer> finalized = new HashMap<>();
        for (String v: g.getVertices()) {
            finalized.put(v, infinity);
        }
        String current = start;
        int weight = 0;
        finalized.put(current, weight);
        while (true) {
            visited.add(current);
            Vertex u = g.getVertex(current);
            for (String v: u.getConnections()) {
                if (!visited.contains(v)) {
                    finalized.put(v,
                            Math.min(finalized.get(v), u.getWeight(v) + weight));
                }
            }
            if (visited.size() == size)
                break;
            int min = infinity;
            String next = "";
            for (Map.Entry<String, Integer> entry: finalized.entrySet()) {
                if (!visited.contains(entry.getKey())) {
                    if (entry.getValue() < min) {
                        min = entry.getValue();
                        next = entry.getKey();
                    }
                }
            }
            current = next;
            weight = finalized.get(current);
        }
        for (String v: g.getVertices()) {
            System.out.println(start + " - " + v + " = " + finalized.get(v));
        }
    }
}