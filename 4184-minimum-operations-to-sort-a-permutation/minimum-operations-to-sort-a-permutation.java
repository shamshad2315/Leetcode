 
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int pos = 0;

        while (nums[pos] != 0) {
            pos++;
        }

        // Case 1: Left rotations only
        boolean normal = true;

        for (int i = 0; i < n; i++) {
            if (nums[(i + pos) % n] != i) {
                normal = false;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (normal) {
            ans = Math.min(pos, n - pos + 2);
        }

        // Case 2: Reverse and rotations
        int k = (pos + 1) % n;
        boolean reversed = true;

        for (int i = 0; i < n; i++) {
            int idx = (k + n - 1 - i) % n;

            if (nums[idx] != i) {
                reversed = false;
                break;
            }
        }

        if (reversed) {
            ans = Math.min(ans, Math.min(k + 1, n - k + 1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
