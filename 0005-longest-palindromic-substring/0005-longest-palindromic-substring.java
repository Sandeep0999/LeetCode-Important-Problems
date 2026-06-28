class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String p = new StringBuilder(s).reverse().toString();
        
        int[][] dp = new int[n + 1][n + 1];
        
        int max = 0;
        int end = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // 🧠 Key fix: check if indices align properly
                    int originalStart = i - dp[i][j];
                    int reversedStart = n - j;

                    if (originalStart == reversedStart) {
                        if (dp[i][j] > max) {
                            max = dp[i][j];
                            end = i - 1;
                        }
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s.substring(end - max + 1, end + 1);
    }
}