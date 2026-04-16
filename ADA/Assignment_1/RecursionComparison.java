import java.util.HashMap;
import java.util.Map;

public class RecursionComparison {

    static int factCalls = 0;
    static int fibCalls = 0;
    static int fibDpCalls = 0;

    // ---------- Factorial ----------
    public static int factorial(int n) {
        factCalls++;
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // ---------- Fibonacci Naive ----------
    public static int fibonacci(int n) {
        fibCalls++;
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ---------- Fibonacci DP ----------
    public static int fibonacciDP(int n, Map<Integer, Integer> memo) {
        fibDpCalls++;

        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 1) return n;

        int result = fibonacciDP(n - 1, memo) + fibonacciDP(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {

        int[] sizes = {5, 10, 20, 30};

        System.out.println("----- CALL COUNT DATA (Copy to Excel) -----");
        System.out.println("n,Factorial Calls,Fibonacci Calls,Fibonacci DP Calls");

        for (int n : sizes) {

            factCalls = 0;
            fibCalls = 0;
            fibDpCalls = 0;

            factorial(n);
            int fCalls = factCalls;

            fibonacci(n);
            int fibNaiveCalls = fibCalls;

            fibonacciDP(n, new HashMap<>());
            int fibDPCalls = fibDpCalls;

            System.out.println(n + "," + fCalls + "," + fibNaiveCalls + "," + fibDPCalls);
        }

        System.out.println("\n----- TIME DATA (Copy to Excel) -----");
        System.out.println("n,Fibonacci Naive Time,Fibonacci DP Time");

        for (int n : sizes) {

            fibCalls = 0;
            fibDpCalls = 0;

            // Naive Fibonacci Time
            long start = System.nanoTime();
            fibonacci(n);
            double naiveTime = (System.nanoTime() - start) / 1e6;

            // DP Fibonacci Time
            start = System.nanoTime();
            fibonacciDP(n, new HashMap<>());
            double dpTime = (System.nanoTime() - start) / 1e6;

            System.out.println(n + "," + naiveTime + "," + dpTime);
        }
    }
}