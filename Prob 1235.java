/*
1235. Maximum Profit in Job Scheduling
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime , endTime and profit arrays, you need to output the maximum profit you can take such that there are no 2 jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.
Example 1:
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
Constraints:
1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
1 <= startTime[i] < endTime[i] <= 10^9
1 <= profit[i] <= 10^4
*/
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
         int n = startTime.length;
        int jobs[][] = new int[n][3];
        for(int i = 0;i < n;i ++){
         jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};  
        }
        Arrays.sort(jobs,(a,b) -> a[1] - b[1]);        
        int dp [] = new int [n + 1];
        Arrays.fill(dp,0);
        dp[0] = jobs[0][2];        
        for(int i = 1;i < n;i++){
            dp[i] = Math.max(jobs[i][2],dp[i - 1]);           
            for(int j = i - 1;j >= 0;j--)
            {
                if(jobs[i][0]>=jobs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + jobs[i][2]);                  
                    break;
                }
            }                         
        }
        return dp[n - 1];        
    }
}
/*
Other solution
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
         int n = startTime.length;
        int jobs[][] = new int[n][3];
        for(int i = 0;i < n;i ++){
         jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};  
        }
        Arrays.sort(jobs,(a,b) -> a[1] - b[1]);        
        TreeMap <Integer,Integer> map = new TreeMap<>();
        map.put(0,0);
        for(int j []: jobs){
            int curr = map.floorEntry(j[0]).getValue() + j[2];
            int val = map.lastEntry().getValue();
            System.out.print(curr + "\n");
            if(curr > val)
                map.put(j[1],curr);
        }
        return map.lastEntry().getValue();        
    }
}
*/
