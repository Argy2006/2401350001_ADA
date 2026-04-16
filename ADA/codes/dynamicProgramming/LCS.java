public class LCS {

    public static void computeLCS(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();

        int table[][] = new int[len1 + 1][len2 + 1];

        // Build DP table
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    table[i][j] = 1 + table[i - 1][j - 1];
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }

        System.out.println("LCS Length = " + table[len1][len2]);

        // Backtracking
        int i = len1, j = len2;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            }
            else if (table[i - 1][j] >= table[i][j - 1]) {
                i--;
            }
            else {
                j--;
            }
        }

        System.out.println("Longest Common Subsequence = " + result.toString());
    }

    public static void main(String[] args) {

        String str1 = "1234125";
        String str2 = "341213";

        computeLCS(str1, str2);
    }
}