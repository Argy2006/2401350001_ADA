// write a java program to implement merge sort algorithm with a loop that counts the number of steps taken to sort the array  
public class Merge_sort{
    public static void main(String[] args) {
      
        int[] arr = new int [15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        System.out.println("Array before sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        int steps = mergeSort(arr);
        System.out.println("\nNumber of steps taken: " + steps);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int mergeSort(int[] arr) {
        int steps = 0;
        if (arr.length < 2) {
            return steps;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
            steps++;
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
            steps++;
        }
        steps += mergeSort(left);
        steps += mergeSort(right);
        steps += merge(arr, left, right);
        return steps;
    }

    public static int merge(int[] arr, int[] left, int[] right) {
        int steps = 0;
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
                steps++;
            } else {
                arr[k++] = right[j++];
                steps++;
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
            steps++;
        }
        while (j < right.length) {
            arr[k++] = right[j++];
            steps++;
        }
        return steps;
    }
}
