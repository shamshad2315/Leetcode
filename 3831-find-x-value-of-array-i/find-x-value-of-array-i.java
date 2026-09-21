 class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
        long[] newDp = new long[k];
                newDp[num % k]++;
            for (int r = 0; r < k; r++) {

                int newRemainder = (int) ((long) r * num % k);

                newDp[newRemainder] += dp[r];
            }

            // Current subarrays ko final answer mein add karo
            for (int r = 0; r < k; r++) {

                result[r] += newDp[r];
            }
            dp = newDp;
        }
        return result;
    }
}