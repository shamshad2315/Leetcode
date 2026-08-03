class Solution {
    public int[] beautifulArray(int n) {

    List<Integer> list = new ArrayList<>();
        list.add(1);

        while (list.size() < n) {

            List<Integer> temp = new ArrayList<>();

            // Generate odd numbers
            for (int x : list) {
                if (2 * x - 1 <= n)
                    temp.add(2 * x - 1);
            }

            // Generate even numbers
            for (int x : list) {
                if (2 * x <= n)
                    temp.add(2 * x);
            }

            list = temp;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = list.get(i);

        return ans;
    }
}
    
