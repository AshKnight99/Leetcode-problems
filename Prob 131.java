/*
131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/
class Solution {
    List <List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null)
            return res;
        helper(s,0,new ArrayList<String>());   
        return res;
    }
           public void helper(String s,int i ,List<String> l){
               if(i == s.length()){
                  res.add(new ArrayList(l)); 
                   return;
               }                     
               for(int k = i;k < s.length();k++){
                   String str = s.substring(i, k + 1);
                   if(isPal(str)){
                       l.add(str);
                       helper(s,k + 1,l);
                       l.remove(l.size() - 1);
                   }
               }                   
           }
        boolean isPal(String s){
            if( s.length() == 0)
                return true;
            for(int k = 0;k < s.length();k++){
                if(s.charAt(k) != s.charAt(s.length() - 1 - k))
                    return false;
            }
            return true;            
        }
    
}