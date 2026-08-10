 import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        List<Integer> minutes = new ArrayList<>();

        // Convert HH:MM to total minutes
        for (String time : timePoints) {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));

            minutes.add(hour * 60 + minute);
        }

        // Sort times
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        // Check adjacent times
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(
                minDiff,
                minutes.get(i) - minutes.get(i - 1)
            );
        }

        // Check circular difference: last -> first
        int circularDiff = 1440 - minutes.get(minutes.size() - 1)
                           + minutes.get(0);

        minDiff = Math.min(minDiff, circularDiff);

        return minDiff;
    }
}