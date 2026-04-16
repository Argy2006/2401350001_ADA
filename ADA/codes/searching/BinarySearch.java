import java.util.Scanner;
class linear {
    int size;
    int a[];
    int key;

    void getdata() {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of element");
        size = sc.nextInt();
        a = new int[size];
        for (i = 0; i < size; i++) {
            System.out.println("Enter " + size + " numbers in array :");
            a[i] = sc.nextInt();
        }
        System.out.println("ENter number for search :");
        key = sc.nextInt();
    }

    void search() {
        int i = 0;
        int j = a.length - 1;
        int step = 0;
        if (size == 1) {
            step++;
            if (a[0] == key) {
                System.out.println("Value found at position 0");
            } else {
                System.out.println("Value not found");
            }
            return;
        }
        while (i <= j) {
            step++;
            int mid = (i + j) / 2;

            if (a[mid] == key) {
                System.out.println("Value found at" + mid + " position");
                break;
            } else if (a[mid] > key) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        System.out.println("Total steps: " + step);
    }
}
class binnarysearch {
    public static void main(String args[]) {
        linear aa = new linear();
        aa.getdata();
        aa.search();
    }
}