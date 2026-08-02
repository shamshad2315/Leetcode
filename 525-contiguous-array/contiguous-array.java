 import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        map.put(0, -1);

        int result = 0;

        for (int i = 0; i < n; i++) {

         
            currSum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(currSum)) {
                result = Math.max(result, i - map.get(currSum));
            } else {
                map.put(currSum, i);
            }
        }

        return result;
    }
}