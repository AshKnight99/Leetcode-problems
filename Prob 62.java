/*
62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?
Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:
Input: m = 7, n = 3
Output: 28
*/
class Solution {
    int count = 1;
    public int uniquePaths(int m, int n) {
        int visited[][] = new int[m + 1][n + 1];
        for(int i[]:visited )
            Arrays.fill(i,1);
        for(int i = 1;i <= m;i ++){
            for(int  j = 1;j <= n;j++){
                visited[i][j] = visited[i - 1][j] + visited[i][j - 1];
            }
        }       
        return visited[m - 1][n - 1];
    }
}