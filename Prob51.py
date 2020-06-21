"""
51. N-Queen
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],
 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
"""
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = [] 
        pos = [-1] * n
        self.helper(pos,0,n)
        return self.result
    
    def helper(self,nums,row,n):
        if row == n:
            self.saveValue(row,nums,n)
            return
        for col in range(n):            
            nums[row] = col                    
            if self.safe(nums,row):               
                self.helper(nums,row + 1,n)
                
    def safe(self, nums, n):
        for i in range(n):
            if nums[i] == nums[n] or abs(nums[i] - nums[n]) == n - i:
                return False
        return True
            
    def saveValue(self,row,nums,n):
        board , res = [], []
        for i in range(n):
            for j in range(n):
                if nums[i] == j:
                    res.append('Q')
                else:
                    res.append('.')
            board.append(''.join(res))
            res.clear()
        self.result.append(board)
        
