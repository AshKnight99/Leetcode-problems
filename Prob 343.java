/*
343. Integer Break
Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
Example 1:
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.
*/
class Solution {
    public int integerBreak(int n) {
//Like cutting rods or unbounded knapsack
        if (n == 0) return 0;
        /*int dp[] = new int[n + 1];       
         dp[0] = 1;   
        for(int i = 1;i < n ;i++){
            for(int j = i;j <= n;j++){                
            dp[j] = Math.max(dp[j],i * dp[j - i]);
                System.out.print(dp[j] + "\t");
            }
             System.out.print("\n");
        }
        
        return dp[n];
        */
        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0;i <= n;i++){
            dp[i][0] = 1;
            dp[0][i] = 1;
        }
        dp[0][0] = 1;
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                    dp[i][j] = dp[i - 1][j];
                    if(j >= i)
                    dp[i][j] = Math.max(dp[i - 1][j],i * dp[i][j - i]);
            System.out.print(dp[i][j] + "\t");
            }
             System.out.print("\n");
        }
        return dp[n - 1][n];
    }
}