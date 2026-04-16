import java.util.*;

public class BFS_DFS {

    int vertices;
    ArrayList<ArrayList<Integer>> list;

    BFS_DFS(int v) {
        vertices = v;
        list = new ArrayList<>();

        for (int i = 0; i < v; i++)
            list.add(new ArrayList<>());
    }

    void connect(int a, int b) {
        list.get(a).add(b);
    }

    // Breadth First Search
    void bfsTraversal(int start) {
        boolean visited[] = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        System.out.print("BFS Order: ");

        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");

            for (int neighbour : list.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
        System.out.println();
    }

    // Depth First Search
    void dfsHelper(int node, boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbour : list.get(node)) {
            if (!visited[neighbour])
                dfsHelper(neighbour, visited);
        }
    }

    void dfsTraversal(int start) {
        boolean visited[] = new boolean[vertices];
        System.out.print("DFS Order: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        BFS_DFS g = new BFS_DFS(6);

        g.connect(0, 2);
        g.connect(0, 3);
        g.connect(1, 4);
        g.connect(2, 5);
        g.connect(3, 1);
        g.connect(4, 5);

        g.bfsTraversal(0);
        g.dfsTraversal(0);
    }
}