class Solution {
    public int maxPalindromes(String s, int k) {

  int n = s.length();
   if (k > n)return 0;

   boolean[][] isPal = new boolean[n][n];
   for(int i = n- 1; i >= 0;i--){
    isPal[i][i] = true;

     for(int j = i + 1; j < n; j++){
        if(s.charAt(i) == s.charAt(j)){
            isPal[i][j] = (j - i == 1) || isPal[i + 1][j - 1];
        }
     }
   }
   int[] db = new int[n + 1];
   for(int i = 1 ; i <= n; i++){
    db[i] = db[i - 1];

    if (i - k >= 0 && isPal[i - k][i - 1]){
        db[i] = Math.max(db[i], db[i - k] + 1);
}
if (i - k - 1 >= 0 && isPal[i - k - 1][i - 1]){
    db[i] = Math.max(db[i],db[i - k -1] + 1);
}
   }
   return db[n];
    }
}