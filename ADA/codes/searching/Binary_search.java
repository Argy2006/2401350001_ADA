// write a java program to implement binary search algorithm with a loop that counts the number of steps taken to find an element in a sorted array also show the array 
public class Binary_search {
    public static int binarySearch(int[] arr, int target) {
        int steps = 0;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                System.out.println("Element found at index " + mid);
                return steps;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Element not found");
        return steps;
    }

    public static void main(String[] args) {
       int[] arr = new int [5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        int target = arr[arr.length / 2]; 
        int steps = binarySearch(arr, target);
        System.out.println("Number of steps taken: " + steps);
       
        System.out.print("Array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a number to search in the array: ");
        int userInput = scanner.nextInt();
        int steps2 = binarySearch(arr, userInput);
        System.out.println("Number of steps taken to search for " + userInput + ": " + steps2);
    }
}