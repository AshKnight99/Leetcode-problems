"""
52. n-Queen II
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
"""
class Solution:
    def totalNQueens(self, n: int) -> int:
        self.res = []
        self.helper([-1] * n,0,n)       
        return len(self.res)

    def helper(self,nums,row,n):
        if row == n:
            self.saveValue(nums,row,n)
            return
        for col in range(n):
            nums[row] = col
            if self.checkValue(nums,row):
                self.helper(nums,row + 1,n)
    
    def checkValue(self,nums,row):
        for queen in range(row):
            if nums[queen] == nums[row] or abs(nums[queen] - nums[row]) == row - queen:
                return False
        return True
    
    def saveValue(self,nums,row,n):
        board,check = [], []
        for i in range (row):
            for j in range(n):
                if(nums[i] == j):
                    check.append('Q')
                else:
                    check.append('.')
                
            board.append(''.join(check))
            check.clear()
        self.res.append(board)        