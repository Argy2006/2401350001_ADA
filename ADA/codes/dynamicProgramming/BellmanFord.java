class BellmanFord {

    class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    int V, E;
    Edge edge[];

    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
    }

    void bellmanFord(int src) {
        int dist[] = new int[V];

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int w = edge[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check negative cycle
        for (int j = 0; j < E; j++) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int w = edge[j].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Negative weight cycle detected");
                return;
            }
        }

        System.out.println("Vertex \t Distance");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 7;

        BellmanFord graph = new BellmanFord(V, E);

        graph.edge[0] = graph.new Edge(0, 1, 6);
        graph.edge[1] = graph.new Edge(0, 3, 7);
        graph.edge[2] = graph.new Edge(1, 2, 5);
        graph.edge[3] = graph.new Edge(1, 3, 8);
        graph.edge[4] = graph.new Edge(1, 4, -4);
        graph.edge[5] = graph.new Edge(2, 4, 2);
        graph.edge[6] = graph.new Edge(3, 2, -3);

        graph.bellmanFord(0);
    }
}