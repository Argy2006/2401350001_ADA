import java.util.*;

public class ComplexityAnalysis {

    // O(1)
    public static int constantTime(int[] arr) {
        return arr[0];
    }

    // O(n)
    public static int linearTime(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    // O(n^2)
    public static void quadraticTime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[i] + arr[j];
            }
        }
    }

    // O(log n)
    public static int logarithmicTime(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] sizes = {10, 100, 500, 1000};

        System.out.println("n,O(1),O(n),O(n^2),O(log n)");

        for (int n : sizes) {

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i;

            // O(1)
            long start = System.nanoTime();
            constantTime(arr);
            double t1 = (System.nanoTime() - start) / 1e6;

            // O(n)
            start = System.nanoTime();
            linearTime(arr);
            double t2 = (System.nanoTime() - start) / 1e6;

            // O(n^2)
            start = System.nanoTime();
            quadraticTime(arr);
            double t3 = (System.nanoTime() - start) / 1e6;

            // O(log n)
            start = System.nanoTime();
            logarithmicTime(arr, n - 1);
            double t4 = (System.nanoTime() - start) / 1e6;

            System.out.println(n + "," + t1 + "," + t2 + "," + t3 + "," + t4);
        }
    }
}