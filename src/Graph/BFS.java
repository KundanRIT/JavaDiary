package Graph;

import java.util.*;

public class BFS {
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

        bfs("0", "8", g);
    }

    public static void bfs(String start, String end, Graph g) {
        LinkedList<Vertex> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        HashMap<String, String> connection = new HashMap<>();
        visited.add(start);
        connection.put(start, null);
        queue.add(g.getVertex(start));
        boolean flag = false;
        while (!queue.isEmpty()) {
            Vertex pop = queue.pop();
            for (String v: pop.getConnections()) {
                if (!visited.contains(v)) {
                    queue.addLast(g.getVertex(v));
                    visited.add(v);
                    connection.put(v, pop.id);
                    if (v.equals(end)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag)
                break;
        }
        if (visited.contains(end)) {
            String current = end;
            while (current != null) {
                System.out.print(current + " ");
                current = connection.get(current);
            }
        } else {
            System.out.println("No Connection");
        }

    }
}
