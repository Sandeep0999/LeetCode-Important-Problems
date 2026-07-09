class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        this.dp = new int[n][amount+1];
        for(int row[] : dp) Arrays.fill(row, -1);
        int ans = func(n-1, coins, amount);
        return ans != (int)1e9 ? ans : -1;
    }
    public int func(int i, int coins[], int t){
        if(i == 0){
            if(t % coins[0] == 0) return t/coins[0];
            else return (int)1e9;
        }
        if(dp[i][t] != -1) return dp[i][t];
        int notTake = func(i-1, coins, t);
        int take = (int)1e9;
        if(coins[i] <= t) take = 1 + func(i, coins, t - coins[i]);
        return dp[i][t] = Math.min(take, notTake);
    }
}