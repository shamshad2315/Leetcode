 class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best = values[0];
         // max(values[i] + i)
        int ans = Integer.MIN_VALUE;

        for (int j = 1; j < values.length; j++) {

            // Choose the best i before j
            ans = Math.max(ans, best + values[j] - j);

            // Make current j available as a future i
            best = Math.max(best, values[j] + j);
        }

        return ans;
    }
}