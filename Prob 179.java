/*
179. Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.
Example 1:
Input: [10,2]
Output: "210"
Example 2:
Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/
class Solution {
    public String largestNumber(int[] A) {
        int n = A.length;
        String s[] = new String[n];
        for(int i = 0;i < n;i++)
            s[i] = String.valueOf(A[i]);
        Arrays.sort(s,(a,b) -> (b + a).compareTo( a + b));
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length;i++){
            sb.append(s[i]);
        }
        return  sb.toString().charAt(0) == '0' ? "0" : sb.toString() ;
    }
}