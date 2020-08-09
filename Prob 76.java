/*
76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
class Solution {
    public String minWindow(String s, String t) {
        Map <Character,Integer> map = new HashMap<>();
        for(char i : t.toCharArray())
            map.put(i,map.getOrDefault(i,0) + 1);
        //System.out.print(map.values());
        int count = 0;
        int left = 0;
        int minlen = Integer.MAX_VALUE;
        String maxStr = "";
        for(int right = 0;right < s.length();right++){
            char x = s.charAt(right);
            if(!map.containsKey(x))
                continue;               
                map.put(x,map.get(x) - 1);
            if(map.get(x) >= 0)
                count++;
            while(count == t.length() && left <= right){
                int currlen = right - left + 1;
                if(currlen < minlen){
                    minlen = currlen;
                    maxStr = s.substring(left,right + 1);
                   // System.out.print("\n"+maxStr);
                }
                char leftch = s.charAt(left);
                left++;
                if(!map.containsKey(leftch))
                    continue;
                map.put(leftch,map.get(leftch) + 1);
                if(map.get(leftch) == 1)
                    count--;                  
            }
           // System.out.print(left + "\t" + right);            
        }
        return (maxStr.length() == 0) ?"": maxStr;        
    }
}