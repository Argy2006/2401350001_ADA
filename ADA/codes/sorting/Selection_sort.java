// / write a java program to implement selection sort algorithm with a loop that counts the number of steps taken to sort the array  
public class Selection_sort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int steps = 0; 

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                steps++; 
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println("Total steps taken: " + steps);
    }

    public static void main(String[] args) {
        int[] arr = new int [10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        selectionSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
