'''
541. Reverse String II
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
'''
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        i = 0
        res = ""
        while (i < len(s)):
            next_i = min(len(s),i + k)            
            temp = s[i:next_i]
            res += temp[::-1]
            next_norm = min(len(s),next_i + k)
            if (next_norm > next_i):
                res += s[next_i:next_norm]
            i += 2 * k
        return res