class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();
        int t[][] = new int[n+1][n+1];
        for(int i = 1; i<t.length; i++){
            for(int j = 1; j<t[0].length; j++){
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                if(ch1==ch2){
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][n];
    

        
    }
}