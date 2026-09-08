 class Solution {
    public int countCommas(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            count += (s.length() - 1) / 3;
        }
        return count;
    }
}