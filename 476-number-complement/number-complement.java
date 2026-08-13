 class Solution {
    public int findComplement(int num) {

        int result = 0;
        int position = 0;

        while (num > 0) {

            int bit = num & 1;

            if (bit == 0) {
                result = result | (1 << position);
            }

            num = num >> 1;
            position++;
        }

        return result;
    }
}