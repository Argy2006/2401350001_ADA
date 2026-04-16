import java.util.Random;

public class Quicksort {

    static long comparisons = 0;

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void Quicksort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            Quicksort(arr, low, pi - 1);
            Quicksort(arr, pi + 1, high);
        }
    }

    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(1000);
        return arr;
    }

    public static int[] generateSortedArray(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    public static void main(String[] args) {
        int sizes[] = {10, 20, 30, 40};

        for (int size : sizes) {
            System.out.println("Input Size: " + size);

            // Average Case
            int avg[] = generateRandomArray(size);
            comparisons = 0;
            Quicksort(avg, 0, size - 1);
            System.out.println("Average Case Comparisons: " + comparisons);

            // Worst Case
            int worst[] = generateSortedArray(size);
            comparisons = 0;
            Quicksort(worst, 0, size - 1);
            System.out.println("Worst Case Comparisons: " + comparisons);

            System.out.println("----------------------");
        }
    }
}