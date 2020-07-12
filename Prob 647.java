/*
647. Palindromic Substrings
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c". 

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/
class Solution {
    public int countSubstrings(String s) {
        StringBuilder sb = new StringBuilder(s);       
        int ans = 0;
        for( int i = 0;i < s.length();i++){
            //odd length
             ans += LPS(s,i, i);              
            //even length
            if(i + 1 < s.length())
                ans += LPS(s,i,i+1);            
            
        }
        return ans;
    }
    int LPS(String s, int left, int right){
        int cnt = 0;
        while((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
            cnt++;
        }
        //System.out.print(s.substring(left + 1, right));
        return cnt;
    }
}