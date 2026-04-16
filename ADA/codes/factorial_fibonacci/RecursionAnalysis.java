import java.util.HashMap;
import java.util.Map;

public class RecursionAnalysis {

    static int fibCalls = 0;
    static int fibDpCalls = 0;

    // ---------- Fibonacci Naive ----------
    static int fibonacci(int n) {
        fibCalls++;
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ---------- Fibonacci DP ----------
    static int fibonacciDP(int n, Map<Integer, Integer> memo) {
        fibDpCalls++;

        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 1) return n;

        int result = fibonacciDP(n - 1, memo) + fibonacciDP(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {

        int[] sizes = {5, 10, 20, 30};

        // ---------- TIME DATA ----------
        System.out.println("----- TIME DATA  -----");
        System.out.println("n,Naive Time,DP Time");

        for (int n : sizes) {

            fibCalls = 0;
            fibDpCalls = 0;

            // Naive Time
            long start = System.nanoTime();
            fibonacci(n);
            double naiveTime = (System.nanoTime() - start) / 1e6; // ms

            // DP Time
            start = System.nanoTime();
            fibonacciDP(n, new HashMap<>());
            double dpTime = (System.nanoTime() - start) / 1e6; // ms

            System.out.println(n + "," + naiveTime + "," + dpTime);
        }

        // ---------- CALL COUNT DATA ----------
        System.out.println("\n----- CALL COUNT DATA  -----");
        System.out.println("n,Naive Calls,DP Calls");

        for (int n : sizes) {

            fibCalls = 0;
            fibDpCalls = 0;

            fibonacci(n);
            int naiveCalls = fibCalls;

            fibonacciDP(n, new HashMap<>());
            int dpCalls = fibDpCalls;

            System.out.println(n + "," + naiveCalls + "," + dpCalls);
        }
    }
}