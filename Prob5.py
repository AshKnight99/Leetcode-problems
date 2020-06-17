"""
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: "cbbd"
Output: "bb"
"""
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None or (s == s[::-1]):
            return s
        palindrome = ""
        for i in range(len(s)):
            s1_val = self.longestpal(s,i,i)
            if len(s1_val) > len(palindrome):
                palindrome = s1_val
            s2_val = self.longestpal(s,i,i + 1)
            if len(s2_val) > len(palindrome):
                palindrome = s2_val
        return palindrome
    def longestpal(self,s,left,right):
        while (left >= 0) and (right < len(s)) and (s[left] == s[right]):
            left -= 1
            right += 1
        return s[left + 1: right]
        