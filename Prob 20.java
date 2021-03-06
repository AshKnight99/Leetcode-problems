/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 1:
Input: "()"
Output: true
Example 2:
Input: "()[]{}"
Output: true
Example 3:
Input: "(]"
Output: false
Example 4:
Input: "([)]"
Output: false
Example 5:
Input: "{[]}"
Output: true
*/
class Solution {
    public boolean isValid(String s1) {
        Stack <Character> s = new Stack<>();
        for(char ch : s1.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[')                
                s.push(ch);
            else{
            if(s.isEmpty())
                return false;
            
            char peek = s.peek();
            if(ch == ')' && peek != '(')
                return false;
            else if(ch == '}' && peek != '{')
                return false;
            else if(ch == ']' && peek != '[')
                return false;
            s.pop();
            }
        }
        if(s.isEmpty())
        return true;
        return false;
    }
}