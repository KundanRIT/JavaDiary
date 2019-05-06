package Graph;

public class Krushkal {
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

    static class Edge implements Comparable<Edge> {
        int weight;
        String v1;
        String v2;

        public Edge(int weight, String v1, String v2) {
            this.weight = weight;
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
