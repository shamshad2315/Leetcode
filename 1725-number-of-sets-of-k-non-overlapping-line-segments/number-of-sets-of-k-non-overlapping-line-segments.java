 class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;
     
        long[][] dp = new long[k + 1][2];
        dp[0][0] = 1; 
    
        for (int i = 1; i <= n - 1; i++) {
            long[][] ndp = new long[k + 1][2];
            for (int j = 0; j <= k; j++) {
               
                ndp[j][0] = (dp[j][0] + dp[j][1]) % MOD;

                
                long val = dp[j][1];  
                if (j >= 1) {
                   
                    val = (val + dp[j - 1][0] + dp[j - 1][1]) % MOD;
                }
                ndp[j][1] = val;         }
           dp = ndp;
        }
        return (int) ((dp[k][0] + dp[k][1]) % MOD);
    }
}