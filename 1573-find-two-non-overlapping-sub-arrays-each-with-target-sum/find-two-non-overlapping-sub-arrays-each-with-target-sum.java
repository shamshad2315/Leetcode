 class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;  
        
         int[] best = new int[n];
        Arrays.fill(best, INF);
        
        int left = 0;
        int currSum = 0;
        int minLen = INF;   
        int result = INF;  
        
        for (int right = 0; right < n; right++) {
            currSum += arr[right];
            
             while (currSum > target && left <= right) {
                currSum -= arr[left];
                left++;
            }
            
             if (currSum == target) {
                int length = right - left + 1;
                
                 if (left > 0 && best[left - 1] != INF) {
                    result = Math.min(result, best[left - 1] + length);
                }
                 minLen = Math.min(minLen, length);
            }    
          best[right] = minLen;
        }
        
        return result == INF ? -1 : result;
    }
}