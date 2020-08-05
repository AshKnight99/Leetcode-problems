/*
67. Add Binary
Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
Constraints:
Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*/
class Solution {
    public String addBinary(String a, String b) {
        /*int x = Integer.parseInt(a,2);
        int y = Integer.parseInt(b,2);        
        return Integer.toBinaryString((x + y));
        */
        int count = 0;
        StringBuffer sb = new StringBuffer();
        
        int n = a.length() - 1;
        int m = b.length() - 1;
        int val = 0 ;
        while(n >= 0 || m >= 0){
            if(n < 0)
                val = b.charAt(m) - '0' + count;
            else if(m < 0)
                val = a.charAt(n) - '0' + count;
           else
            val = (a.charAt(n) - '0') + (b.charAt(m) - '0') + count;
            //System.out.print(val);
            count = val / 2;
            val = val % 2;
            sb.append(val);
            m --;
            n --;               
        }
        if(count == 1)
            sb.append("1");
        return sb.reverse().toString();
    }
}