 class Solution {
    public int distinctSubseqII(String s) {

        int MOD = 1_000_000_007;

        long[] last = new long[26];
 long total = 1;   
        for (char c : s.toCharArray()) {

            int i = c - 'a';
            long old = total;
            total = (total * 2 - last[i] + MOD) % MOD;
            last[i] = old;
        }
        return (int)((total - 1 + MOD) % MOD);
    }
}