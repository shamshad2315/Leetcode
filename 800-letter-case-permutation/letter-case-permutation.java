 import java.util.*;

class Solution {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s.toCharArray(), 0, result);

        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {

        // Base case
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        // If character is a letter
        if (Character.isLetter(chars[index])) {

            // Lowercase
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(chars, index + 1, result);

            // Uppercase
            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(chars, index + 1, result);

        } else {

            // Digit
            backtrack(chars, index + 1, result);
        }
    }
}