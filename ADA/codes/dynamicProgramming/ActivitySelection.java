import java.util.*;

class Activity {
    int start, finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

public class ActivitySelection {

    public static void selectActivities(Activity arr[]) {

        Arrays.sort(arr, (a, b) -> a.finish - b.finish);

        System.out.println("Selected Activities:");

        int lastFinish = arr[0].finish;
        System.out.println("(" + arr[0].start + ", " + arr[0].finish + ")");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start >= lastFinish) {
                System.out.println("(" + arr[i].start + ", " + arr[i].finish + ")");
                lastFinish = arr[i].finish;
            }
        }
    }

    public static void main(String[] args) {

       Activity arr[] = {
    new Activity(2, 5),
    new Activity(1, 3),
    new Activity(4, 6),
    new Activity(6, 8),
    new Activity(5, 9),
    new Activity(8, 10)
};
        selectActivities(arr);
    }
}