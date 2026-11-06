  
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Sort logs according to time
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        // Store query indices
        Integer[] idx = new Integer[queries.length];

        for (int i = 0; i < queries.length; i++) {
            idx[i] = i;
        }

        // Sort queries according to time
        Arrays.sort(idx, (a, b) -> queries[a] - queries[b]);

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[queries.length];

        int left = 0;
        int right = 0;

        for (int i : idx) {

            int start = queries[i] - x;
            int end = queries[i];

            // Add logs inside the right boundary
            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);
                right++;
            }

            // Remove logs outside the left boundary
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                }

                left++;
            }

            // Servers with zero requests
            ans[i] = n - map.size();
        }

        return ans;
    }
}
