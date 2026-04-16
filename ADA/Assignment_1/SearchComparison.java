import java.util.*;

public class SearchComparison {

    // ---------- Linear Search ----------
    public static int performLinearSearch(int[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) return i;
        }
        return -1;
    }

    // ---------- Binary Search ----------
    public static int performBinarySearch(int[] data, int key) {
        int left = 0, right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (data[mid] == key) return mid;
            else if (data[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // ---------- Generate Sorted Data ----------
    public static int[] generateSortedData(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }

        Arrays.sort(arr);
        return arr;
    }

    // ---------- Measure Time ----------
    public static double measureTime(Runnable task, int repeat) {
        long start = System.nanoTime();

        for (int i = 0; i < repeat; i++) {
            task.run();
        }

        return (System.nanoTime() - start) / 1e6; // ms
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        int[] sizes = {10, 100, 500, 1000};
        int repeat = 1000;

        // ---------- WORST CASE ----------
        System.out.println("----- WORST CASE -----");
        System.out.println("n,Linear Worst,Binary Worst");

        for (int n : sizes) {

            int[] arr = generateSortedData(n);
            int worstKey = -1;

            double linearWorst = measureTime(
                    () -> performLinearSearch(arr, worstKey), repeat);

            double binaryWorst = measureTime(
                    () -> performBinarySearch(arr, worstKey), repeat);

            System.out.println(n + "," + linearWorst + "," + binaryWorst);
        }

        // ---------- AVERAGE CASE ----------
        System.out.println("\n----- AVERAGE CASE -----");
        System.out.println("n,Linear Average,Binary Average");

        for (int n : sizes) {

            int[] arr = generateSortedData(n);
            int avgKey = arr[n / 2];

            double linearAvg = measureTime(
                    () -> performLinearSearch(arr, avgKey), repeat);

            double binaryAvg = measureTime(
                    () -> performBinarySearch(arr, avgKey), repeat);

            System.out.println(n + "," + linearAvg + "," + binaryAvg);
        }

        // ---------- BEST CASE ----------
        System.out.println("\n----- BEST CASE -----");
        System.out.println("n,Linear Best,Binary Best");

        for (int n : sizes) {

            int[] arr = generateSortedData(n);
            int bestKey = arr[0];

            double linearBest = measureTime(
                    () -> performLinearSearch(arr, bestKey), repeat);

            double binaryBest = measureTime(
                    () -> performBinarySearch(arr, bestKey), repeat);

            System.out.println(n + "," + linearBest + "," + binaryBest);
        }
    }
}