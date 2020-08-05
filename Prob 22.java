/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
class Solution {
    List <String> l;
    public List<String> generateParenthesis(int n) {
         l = new ArrayList<>();
        helper(n,n,"");
        return l;
    }
    public void helper(int left,int right,String ip){
     if(right == 0){
         l.add(ip);
         return;
     }   
        if(left > 0)
           helper(left - 1,right,ip + "("); 
        if(left < right)
            helper(left,right - 1,ip + ")");        
    }
}