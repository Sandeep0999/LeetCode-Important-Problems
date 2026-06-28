class Solution {
    public int longestPalindromeSubseq(String s) {
        String q = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = q.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m;j++){
                if(s.charAt(i-1) == q.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}