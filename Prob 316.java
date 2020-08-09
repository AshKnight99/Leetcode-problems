/*
316. Remove Duplicate Letters
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
Example 1:
Input: "bcabc"
Output: "abc"
Example 2:
Input: "cbacdcbc"
Output: "acdb"
*/
class Solution {
    public String removeDuplicateLetters(String s) {
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