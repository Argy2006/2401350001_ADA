public class MatrixChainMultiplication {

    static char name = 'A';

    public static void matrixChainOrder(int p[], int n) {
        int dp[][] = new int[n][n];
        int bracket[][] = new int[n][n];

        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }

        // 🔥 PRINT MATRIX NAMES + DIMENSIONS
        System.out.println("Matrices:");
        for (int i = 1; i < n; i++) {
            char matrixName = (char) ('A' + i - 1);
            System.out.println(matrixName + " = " + p[i - 1] + " x " + p[i]);
        }

        System.out.println("\nMinimum Multiplications = " + dp[1][n - 1]);

        System.out.print("Optimal Parenthesization: ");
        name = 'A'; // reset
        printParenthesis(1, n - 1, bracket);
    }

    public static void printParenthesis(int i, int j, int bracket[][]) {
        if (i == j) {
            System.out.print(name++);
            return;
        }

        System.out.print("(");
        printParenthesis(i, bracket[i][j], bracket);
        printParenthesis(bracket[i][j] + 1, j, bracket);
        System.out.print(")");
    }

    public static void main(String[] args) {
    int arr[] = {5, 10, 3, 12, 5, 50, 6};

    matrixChainOrder(arr, arr.length);
}
}