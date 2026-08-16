 class Solution {
    public String greatestLetter(String s) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }

        // Z se A ki taraf check karo
        for (int i = 25; i >= 0; i--) {
            if (lower[i] && upper[i]) {
                return String.valueOf((char) ('A' + i));
            }
        }

        return "";
    }
}
