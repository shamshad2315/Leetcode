 import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {

        // Count frequency of each damage
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int x : power) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int n = map.size();

        int[] values = new int[n];
        long[] gain = new long[n];

        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            values[index] = entry.getKey();
            gain[index] = (long) entry.getKey() * entry.getValue();
            index++;
        }

        long[] dp = new long[n];

        dp[0] = gain[0];

        for (int i = 1; i < n; i++) {

            // Don't take current value
            long skip = dp[i - 1];

            // Find last value <= values[i] - 3
            int j = binarySearch(values, i, values[i] - 3);

            long take = gain[i];

            if (j >= 0) {
                take += dp[j];
            }

            dp[i] = Math.max(skip, take);
        }

        return dp[n - 1];
    }

    private int binarySearch(int[] values, int right, int target) {

        int left = 0;
        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (values[mid] <= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}