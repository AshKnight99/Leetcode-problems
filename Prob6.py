"""
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
"""
class Solution(object):
    def convert(self, s, n):
        """
        :type s: str
        :type n: int
        :rtype: str
        """
        if n == 1 or n >= len(s):
            return s
        converted = [""] * n
        index , step = 0 , 1
        for val in s:
            converted[index] += val
            if index == 0:
                step = 1
            elif index == n - 1:
                step = -1
            index += step 
           
        return "".join(converted)
                
        

"""
Other approach
if n == 1:
            return s
        converted = ""
        for i in range(n):
            j = i
            while (j < len(s)):
                converted += s[j]
                if i != 0 and i != n - 1 and j  + 2 *(n - i -1) < len(s) :
                    converted += s[j + 2 * (n - i -1)]
                 
                j += 2 * n - 2 
        return converted
"""