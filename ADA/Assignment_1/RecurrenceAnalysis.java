
public class RecurrenceAnalysis {

    static int callsT1 = 0;
    static int callsT2 = 0;

    // ---------- T(n) = T(n/2) + n ----------
    public static int T1(int n) {
        callsT1++;

        if (n <= 1) return 1;

        // simulate linear work
        for (int i = 0; i < n; i++) {
            // do nothing
        }

        return T1(n / 2) + n;
    }

    // ---------- T(n) = 2T(n/2) + n ----------
    public static int T2(int n) {
        callsT2++;

        if (n <= 1) return 1;

        // simulate linear work
        for (int i = 0; i < n; i++) {
            // do nothing
        }

        return T2(n / 2) + T2(n / 2) + n;
    }

    public static void main(String[] args) {

        int[] sizes = {8, 16, 32, 64, 128, 256};

        System.out.println("----- CALL COUNT DATA -----");
        System.out.println("n,Calls T1,Calls T2");

        for (int n : sizes) {

            callsT1 = 0;
            callsT2 = 0;

            T1(n);
            int t1Calls = callsT1;

            T2(n);
            int t2Calls = callsT2;

            System.out.println(n + "," + t1Calls + "," + t2Calls);
        }

        System.out.println("\n----- TIME DATA -----");
        System.out.println("n,T1 Time,T2 Time");

        for (int n : sizes) {

            callsT1 = 0;
            callsT2 = 0;

            long start = System.nanoTime();
            T1(n);
            double t1Time = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            T2(n);
            double t2Time = (System.nanoTime() - start) / 1e6;

            System.out.println(n + "," + t1Time + "," + t2Time);
        }
    }
}