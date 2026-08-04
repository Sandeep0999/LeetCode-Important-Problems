class Solution {
    int n;
    int grid[][];
    Integer dp[][][][];
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        this.dp = new Integer[n][n][n][n];
        int result = dfs(0, 0, 0, 0);
        return Math.max(result, 0);
    }
    public int dfs(int r1, int c1, int r2, int c2){
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;
        if(dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];
        if(r1 == n-1 && c1 == n-1) return grid[r1][c1];
        int cherries = grid[r1][c1];
        if(r1 != r2 || c1 != c2) cherries += grid[r2][c2];
        int dd = dfs(r1 + 1, c1, r2 + 1, c2);
        int dr = dfs(r1 + 1, c1, r2, c2 + 1);
        int rd = dfs(r1, c1 + 1, r2 + 1, c2);
        int rr = dfs(r1, c1 + 1, r2, c2 + 1);
        int next = Math.max(Math.max(dd, dr), Math.max(rr, rd));
        if(next == Integer.MIN_VALUE) dp[r1][c1][r2][c2] = Integer.MIN_VALUE;
        else dp[r1][c1][r2][c2] = cherries + next;
        return dp[r1][c1][r2][c2];
    }
}