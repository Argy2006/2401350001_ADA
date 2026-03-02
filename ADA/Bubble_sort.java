// write a java program to implement bubble sort algorithm with a loop that counts the number of steps taken to sort the array also add if the array is already sorted 
import java.util.Scanner;
public class Bubble_sort {

   public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int steps = 0; 
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                steps++; 
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
           
            if (!swapped) {
                System.out.println("Array is already sorted.");
                break;
            }
        }
        System.out.println("Total steps taken: " + steps);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        // also show the array before sorting
        System.out.println("Array before sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
