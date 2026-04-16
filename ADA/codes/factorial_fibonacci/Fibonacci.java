





















public class Fibonacci {

    static int count = 0;   

    public static int fibonacci(int n) {
        count++;           
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 8;

        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\nTotal steps: " + count);
    }
}
















// // create fibanacci series using recursion
// public class Fibonacci {

//     public static int fibonacci(int n) {
//         if (n <= 1) {
//             return n;
//         }
//         return fibonacci(n - 1) + fibonacci(n - 2);
//     }

//     public static void main(String[] args) {
//         int n = 10;
//         System.out.println("Fibonacci series up to " + n + " terms:");
//         for (int i = 0; i < n; i++) {
//             System.out.print(fibonacci(i) + " ");
//         }
//     }
// }

// create fibonacci series using recursion

// create fibonacci series using iteration
// public class Fibonacci { 

//     public static void fibonacci(int n) {
//         int a = 0, b = 1;
//         System.out.print("Fibonacci series up to " + n + " terms:\n");
//         for (int i = 0; i < n; i++) {
//             System.out.print(a + " ");
//             int next = a + b;
//             a = b;
//             b = next;
//         }
//     }

//     public static void main(String[] args) {
//         int n = 10;
//         fibonacci(n);
//     }
// }
// public class Fibonacci { 

//     public static void fibonacci(int n) {
//         int a = 0, b = 1;
//         int count = 0;   // counts loop runs

//         System.out.print("Fibonacci series up to " + n + " terms:\n");
//         for (int i = 0; i < n; i++) {
//             System.out.print(a + " ");
//             int next = a + b;
//             a = b;
//             b = next;
//             count++;    // increment per loop iteration
//         }

//         System.out.println("\nLoop ran " + count + " times");
//     }

//     public static void main(String[] args) {
//         int n = 10;
//         fibonacci(n);
//     }
// }

