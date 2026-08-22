 class Solution {
    public String bestHand(int[] ranks, char[] suits) {

        // 1. Check Flush
        boolean flush = true;

        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                flush = false;
                break;
            }
        }

        if (flush) {
            return "Flush";
        }

        // 2. Count ranks
        int[] count = new int[14];

        for (int rank : ranks) {
            count[rank]++;
        }

        // 3. Check Three of a Kind
        for (int i = 1; i <= 13; i++) {
            if (count[i] >= 3) {
                return "Three of a Kind";
            }
        }

        // 4. Check Pair
        for (int i = 1; i <= 13; i++) {
            if (count[i] >= 2) {
                return "Pair";
            }
        }

        // 5. Nothing matched
        return "High Card";
    }
}