import java.util.*;

public class Dijkstra {

    static final int N = 6;

    int getMin(int distance[], boolean visited[]) {
        int min = Integer.MAX_VALUE, index = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    void findPath(int graph[][], int source) {

        int distance[] = new int[N];
        boolean visited[] = new boolean[N];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < N - 1; i++) {
            int u = getMin(distance, visited);
            visited[u] = true;

            for (int v = 0; v < N; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + graph[u][v] < distance[v]) {

                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("Node \t Shortest Distance");
        for (int i = 0; i < N; i++)
            System.out.println(i + " \t\t " + distance[i]);
    }

    public static void main(String[] args) {

        int matrix[][] = {
            {0, 4, 0, 0, 8, 0},
            {4, 0, 6, 0, 0, 0},
            {0, 6, 0, 3, 0, 5},
            {0, 0, 3, 0, 7, 2},
            {8, 0, 0, 7, 0, 9},
            {0, 0, 5, 2, 9, 0}
        };

        Dijkstra sp = new Dijkstra();
        sp.findPath(matrix, 0);
    }
}