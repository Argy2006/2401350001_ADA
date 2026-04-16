 // write a java program to implement insertion sort algorithm with a loop that counts the number of steps taken to sort the array
public class Insertion_sort {
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int steps = 0; 

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                steps++; 
                arr[j + 1] = arr[j];
                j--;
            }
            if (j >= 0) {
                steps++; 
            }
            arr[j + 1] = key;
        }
        System.out.println("Total steps taken: " + steps);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        // also show the array before sorting
        System.out.println("Array before sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
