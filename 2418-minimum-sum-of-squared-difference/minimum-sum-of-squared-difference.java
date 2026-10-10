 
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long operations = (long) k1 + k2;
        int[] diff = new int[n];

        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        if (operations == 0) {
            return sumSquares(diff);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        if (total <= operations) {
            return 0;
        }

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= operations) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long answer = 0;
        long remaining = operations;

        for (int d : diff) {
            if (d > limit) {
                remaining -= d - limit;
                d = limit;
            }
            answer += (long) d * d;
        }

        // Distribute leftover operations one at a time.
        // Each such operation reduces a difference of 'limit'
        // to 'limit - 1'.
        if (limit > 0) {
            long count = Math.min(remaining, n);
            answer -= count * (2L * limit - 1);
        }

        return answer;
    }

    private long sumSquares(int[] diff) {
        long sum = 0;
        for (int d : diff) {
            sum += (long) d * d;
        }
        return sum;
    }
}
