public class NQueen {

    int N = 5;

    boolean isSafe(int board[][], int row, int col) {

        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean placeQueen(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (placeQueen(board, col + 1))
                    return true;

                board[i][col] = 0;
            }
        }
        return false;
    }

    void solve() {
        int board[][] = new int[N][N];

        if (!placeQueen(board, 0)) {
            System.out.println("Solution not possible");
            return;
        }

        display(board);
    }

    void display(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueen q = new NQueen();
        q.solve();
    }
}