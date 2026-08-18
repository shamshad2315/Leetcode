class Solution {
    public int[] constructTransformedArray(int[] nums) {

          int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int shift = nums[i];

            // New index
            int newIndex = (i + shift) % n;

            // Java me negative modulo aa sakta hai
            if (newIndex < 0) {
                newIndex += n;
            }
            res[i] = nums[newIndex];
        }
        return res;
    }
}  
  