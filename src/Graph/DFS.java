package Graph;

import java.util.*;

public class DFS {
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
        dfsIter("0", "5", g);
    }

    public static void dfs(String start, String end, Graph g) {
        Set<String> visited = new HashSet<>();
        visited.add(start);
        List<String> path = dfs_(start, end, g, visited, new ArrayList<>(Collections.singletonList(start)));
        System.out.println(path);
    }

    private static List<String> dfs_(String current, String end, Graph g, Set<String> visited, List<String> path) {
        if (current.equals(end)) {
            return path;
        }
        for (String v: g.getVertex(current).getConnections()) {
            if (! visited.contains(v)) {
                visited.add(v);
                path.add(v);
                return dfs_(v, end, g, visited, path);
            }
        }
        return null;
    }

    public static void dfsIter(String start, String end, Graph g) {
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Stack<String> stack = new Stack<>();
        stack.add(start);
        List<String> path = new ArrayList<>();
        path.add(start);
        boolean found = false;
        while (!stack.empty()) {
            String current = stack.pop();
            if (current.equals(end)) {
                found = true;
                break;
            }
            for (String v: g.getVertex(current).getConnections()) {
                if (! visited.contains(v)) {
                    visited.add(v);
                    path.add(v);
                    stack.add(v);
                }
            }
        }
        if (found)
            System.out.println(path);
        else
            System.out.println("No Connection");
    }
}