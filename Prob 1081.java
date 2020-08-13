/*
1081. Smallest Subsequence of Distinct Characters
Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.
Example 1:
Input: "cdadabcc"
Output: "adbc"
Example 2:
Input: "abcd"
Output: "abcd"
Example 3:
Input: "ecbacba"
Output: "eacb"
Example 4:
Input: "leetcode"
Output: "letcod"
Constraints:
1 <= text.length <= 1000
text consists of lowercase English letters.
*/
class Solution {
    public String smallestSubsequence(String s) {
       int n = s.length();
        if(n == 0)
            return "";
        Stack <Character> st = new Stack<>();
        int count [] = new int[26];
        boolean visited[] = new boolean[26];
        for(Character ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        for(Character ch : s.toCharArray()){            
               if(!visited[ch-'a']){
                while(!st.isEmpty() && ch<st.peek() && count[st.peek()-'a']!=0){
                    visited[st.pop()-'a']=false;
                }
                st.push(ch);
                count[ch-'a']--;
                visited[ch-'a']=true;
            }else
                count[ch-'a']--;            
        }            
        //System.out.print(st);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();          
    }
}