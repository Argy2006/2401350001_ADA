public class FloydWarshall {

    static final int INF = 9999;

    void computeShortestPaths(int matrix[][]) {

        int n = matrix.length;
        int result[][] = new int[n][n];

        // copy matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = matrix[i][j];

        // Floyd Warshall logic
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (result[i][via] + result[via][j] < result[i][j]) {
                        result[i][j] = result[i][via] + result[via][j];
                    }
                }
            }
        }

        display(result);
    }

    void display(int arr[][]) {

        System.out.println("All Pair Shortest Paths:");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == INF)
                    System.out.print("∞ ");
                else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int matrix[][] = {
            {0, 2, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        FloydWarshall apsp = new FloydWarshall();
        apsp.computeShortestPaths(matrix);
    }
}