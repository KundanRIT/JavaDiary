package Graph;

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
    }

    public static void dfs(String start, String end, Graph g) {

    }
}
