public class knapsack01 {

    public static void solveKnapsack(int wt[], int val[], int items, int capacity) {

        int table[][] = new int[items + 1][capacity + 1];

        // Build DP table
        for (int i = 0; i <= items; i++) {
            for (int c = 0; c <= capacity; c++) {

                if (i == 0 || c == 0)
                    table[i][c] = 0;

                else if (wt[i - 1] <= c)
                    table[i][c] = Math.max(
                            val[i - 1] + table[i - 1][c - wt[i - 1]],
                            table[i - 1][c]
                    );
                else
                    table[i][c] = table[i - 1][c];
            }
        }

        System.out.println("Best Profit = " + table[items][capacity]);

        // Find selected items
        int c = capacity;
        System.out.println("Chosen Items (0/1):");

        for (int i = items; i > 0 && c > 0; i--) {
            if (table[i][c] != table[i - 1][c]) {
                System.out.println("Product " + i + " -> 1");
                c -= wt[i - 1];
            } else {
                System.out.println("Product " + i + " -> 0");
            }
        }
    }

    public static void main(String[] args) {

        int val[] = {40, 70, 80, 120};
        int wt[]  = {5, 10, 20, 30};

        int capacity = 40;
        int items = val.length;

        solveKnapsack(wt, val, items, capacity);
    }
}