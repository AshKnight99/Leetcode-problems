/*
 516. Longest Palindromic Subsequence
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb". 

Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/class Solution {
    public int longestPalindromeSubseq(String s) {
       StringBuilder sb = new StringBuilder(s);
       // if(s.length() == 0 || sb.reverse().toString().equals(s))
         //   return s.length();
        return LPS(s,sb.reverse().toString(),s.length());
    }
    int LPS(String s, String rev, int n){
       int dp [][] = new int[ n + 1][n + 1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= n;j++){
                if( i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s.charAt(i - 1) == rev.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            } 
        }
        return dp[n][n];
    }
}

/*Using Memoization
class Solution {
    public int longestPalindromeSubseq(String s) {
        strg = new int[s.length()][s.length()];
        for(int[] arr: strg){
            Arrays.fill(arr, -1);
        }
        return longestPalindromeSubseq(s ,0, s.length()-1);
    }
    int[][] strg;
    public int longestPalindromeSubseq(String s, int si, int ei){
        if(si==ei){
            return 1;
        }else if(si>ei){
            return 0;
        }
        if(strg[si][ei]!=-1){
            return strg[si][ei];
        }
        char c1 = s.charAt(si);
        char c2 = s.charAt(ei);
        if(c1==c2){
            return strg[si][ei] = longestPalindromeSubseq(s, si+1, ei-1) + 2;
        }else{
            return strg[si][ei] = Math.max(longestPalindromeSubseq(s, si+1, ei), 
                            longestPalindromeSubseq(s, si, ei-1));
        }        
    }
}
*/