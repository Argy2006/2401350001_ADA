public class SumOfSubsets {

    int[] set = {5, 10, 12, 13, 15, 18};
    int target = 30;
    int n = set.length;

    void subset(int sum, int index, boolean[] selected) {

        if (sum == target) {
            System.out.print("Subset:");
            for (int i = 0; i < n; i++) {
                if (selected[i])
                    System.out.print(set[i] + " ");
            }
            System.out.println();
            return;
        }

        if (sum > target || index == n)
            return;

        // Include element
        selected[index] = true;
        subset(sum + set[index], index + 1, selected);

        // Exclude element
        selected[index] = false;
        subset(sum, index + 1, selected);
    }

    public static void main(String[] args) {
        SumOfSubsets obj = new SumOfSubsets();
        boolean selected[] = new boolean[obj.n];
        obj.subset(0, 0, selected);
    }
}