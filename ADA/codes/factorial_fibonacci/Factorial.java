public class Factorial {

    static int count = 0;   

    public static int factorial(int n) {
        count++;            
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 6;
        int result = factorial(n);

        System.out.println("Factorial of " + n + " is: " + result);
        System.out.println("Total steps: " + count);
    }
}









// create factorial using recursion

// public class Factorial {

//     public static int factorial(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         return n * factorial(n - 1);
//     }
//     public static void main(String[] args) {
//         int n = 5;
//         System.out.println("Factorial of " + n + " is: " + factorial(n));
//     }
// }

// // create factorial using iteration
// public class Factorial {

//     public static int factorial(int n) {
//         int result = 1;
//         for (int i = 2; i <= n; i++) {
//             result *= i;
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         int n = 5;
//         System.out.println("Factorial of " + n + " is: " + factorial(n));
//     }
// }


// public class Factorial {

//     static int count = 0;   
//     public static int factorial(int n) {
//         count++;
//         System.out.println("Step " + count + ": factorial(" + n + ") called");

//         if (n == 0 || n == 1) {
//             System.out.println("Step " + count + ": Returning 1");
//             return 1;
//         }

//         int result = n * factorial(n - 1);
//         System.out.println("Step " + count + ": Returning " + result + " for factorial(" + n + ")");
//         return result;
//     }

//     public static void main(String[] args) {
//         int n = 5;
//         int ans = factorial(n);

//         System.out.println("\nFinal Result:");
//         System.out.println("Factorial of " + n + " is: " + ans);
//         System.out.println("Total steps (function calls): " + count);
//     }
// }


// public class Factorial {

//     public static long factorial(int n) {
//         long result = 1;
//         int count = 0;   

//         for (int i = 2; i <= n; i++) {
//             result *= i;
//             count++;
//         }

//         System.out.println("Total steps: " + count);
//         return result;
//     }

//     public static void main(String[] args) {
//         int n = 20;
//         System.out.println("Factorial of " + n + " is: " + factorial(n));
//     }
// }

