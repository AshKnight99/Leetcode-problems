/*
494. Target Sum
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.
Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of nums be target 3. 
Constraints:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0,cnt = 0;
        for(int i = 0;i < nums.length;i++)
        {sum += nums[i];
         if(nums[i] == 0)
             cnt++;
        }
        int val = (S + sum) / 2;  // Check the sum_val of 1 subset
         if(S > sum)
            return 0;
        if((S + sum)%2!=0)
            return 0;
        return helper(nums,val,nums.length,cnt);                
    }s
    int helper(int nums[],int S,int n, int cnt){
        int dp[][] = new int[n  + 1][S + 1];
        for(int i = 0;i <= n ;i++)
            dp[i][0] = 1;
        for(int j = 1;j <= S;j++)
            dp[0][j] = 0;
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= S;j++){
                dp[i][j] = dp[i - 1][j];               
                if(j >= nums[ i - 1])
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if(nums[i - 1] == 0)
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return (int)Math.pow(2.0,(double)cnt) * dp[n][S];
    }
}