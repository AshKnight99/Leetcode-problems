/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non decreasing array.
-10^9 <= target <= 10^9
*/
class Solution {
    public int[] searchRange(int[] nums, int target) { 
        return new int[]{FirstOcc(nums,target),LastOcc(nums,target)};
        
    }
    int FirstOcc(int nums[],int target){
        int start = 0, end = nums.length - 1;
        int mid = 0;
        int ans1 = -1;
        while(start <= end){
             mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans1 = mid;
                end = mid - 1;
            }
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return ans1;
    }
    int LastOcc(int nums[],int target){
        int start = 0, end = nums.length - 1;
        int mid = 0;
        int ans1 = -1;
        while(start <= end){
             mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans1 = mid;
               start = mid + 1;
            }
            else if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return ans1;
    }
}