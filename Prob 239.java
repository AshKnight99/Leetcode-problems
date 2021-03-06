/*
239. Sliding Window Maximum
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k > n)
            return new int[]{};
        int arr[] = new int[n - k + 1];
        int max = nums[0];
        int index = 0;       
        int left = 0;
        int right = left + k - 1;
        int write = 0;
        while (right < n){
            if(left == 0){
            for(int i = 0 ;i  < k;i++){
            if(max < nums[i]){
            max =nums[i];
            index = i;
            }
            }
            arr[write++] = max;            
        }
            else if(index < left){  
                max = nums[left];
                    for(int i = left;i <= right;i++){
                        if(max < nums[i]){
                        max =nums[i];
                        index = i;
                    }
                    }                
                arr[write++] = max;                
            }
            else{
                if(max < nums[right]){
                 max = nums[right];
                 index = right;
                }               
                arr[write++] = max;
            }
            left++;
            right++;
        }
        return arr;
    }
}