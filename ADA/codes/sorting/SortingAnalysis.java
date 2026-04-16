import java.util.Random;

public class SortingAnalysis {

    // ---------- Utility Method: Swap ----------
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ---------- Bubble Sort ----------
    public static long performBubbleSort(int[] data) {
        long comparisonCount = 0;
        int n = data.length;

        for (int pass = 0; pass < n - 1; pass++) {
            boolean isSorted = true;

            for (int i = 0; i < n - pass - 1; i++) {
                comparisonCount++;
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                    isSorted = false;
                }
            }

            if (isSorted) break; // early exit
        }
        return comparisonCount;
    }

    // ---------- Selection Sort ----------
    public static long performSelectionSort(int[] data) {
        long comparisonCount = 0;
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < n; j++) {
                comparisonCount++;
                if (data[j] < data[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            if (smallestIndex != i) {
                swap(data, i, smallestIndex);
            }
        }
        return comparisonCount;
    }

    // ---------- Insertion Sort ----------
    public static long performInsertionSort(int[] data) {
        long comparisonCount = 0;

        for (int i = 1; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;

            while (j >= 0) {
                comparisonCount++;

                if (data[j] > current) {
                    data[j + 1] = data[j];
                    j--;
                } else {
                    break;
                }
            }
            data[j + 1] = current;
        }
        return comparisonCount;
    }

    // ---------- Data Generators ----------
    public static int[] createRandomData(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    public static int[] createSortedData(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] createReverseData(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    // ---------- Display Helper ----------
    public static void displayResults(String caseType, int size,
                                      int[] baseArray) {

        System.out.println("\n" + caseType + " (n = " + size + ")");

        System.out.println("Bubble Sort Comparisons   : " +
                performBubbleSort(baseArray.clone()));

        System.out.println("Selection Sort Comparisons: " +
                performSelectionSort(baseArray.clone()));

        System.out.println("Insertion Sort Comparisons: " +
                performInsertionSort(baseArray.clone()));
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        int[] inputSizes = {10, 20, 30, 40};

        for (int size : inputSizes) {

            System.out.println("\n======================================");
            System.out.println(" ANALYSIS FOR INPUT SIZE = " + size);
            System.out.println("======================================");

            displayResults("BEST CASE (Already Sorted)",
                    size, createSortedData(size));

            displayResults("WORST CASE (Reverse Sorted)",
                    size, createReverseData(size));

            displayResults("AVERAGE CASE (Random Data)",
                    size, createRandomData(size));
        }
    }
}