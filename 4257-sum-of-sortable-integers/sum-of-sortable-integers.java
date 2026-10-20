 
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int end = start + k;
                int descents = 0;
                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;

                for (int i = start; i < end; i++) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);

                    int next = (i + 1 == end) ? start : i + 1;

                    if (nums[i] > nums[next]) {
                        descents++;
                    }
                }

                if (descents > 1 || prevMax > minVal) {
                    valid = false;
                    break;
                }

                prevMax = maxVal;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
