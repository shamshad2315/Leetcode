 class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {

            if (s.charAt(i) == '(') {

                i++;  
                StringBuilder key = new StringBuilder();
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }
 
                String value = map.getOrDefault(key.toString(), "?");

                ans.append(value);
                i++;  
            } else {
            ans.append(s.charAt(i));
                i++;
       }
        }
    return ans.toString();
    }
}