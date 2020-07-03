/*
300.Longest Increasing Subsequence
 Given an unsorted array of integers, find the length of longest increasing subsequence.
Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int length[] = new int[n];
        int max = 0;
     //  List <Integer> list = new ArrayList<>();
   //     int val = -1;
        for(int i = 0;i < n;i++){
            length[i] = 1;
            for(int j = 0;j <= i;j++){
                if(nums[i] > nums[j]){
                    length[i] = Math.max(length[i],length[j] + 1);                   
                  //  val = nums[j];
                    }
            }
             max = Math.max(max,length[i]);
         //   if(val != -1 && !list.contains(val))
           // list.add(val);
        }
       // System.out.print(list);
        return max;
    }
}