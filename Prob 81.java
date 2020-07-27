/*
81. Search in Rotated Sorted Array II
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;        
        return BS(nums,target,0,nums.length - 1);        
    }
  
    boolean BS(int arr[],int target,int start,int end){
        int mid = 0;
         while(start <= end){
            mid = start + (end - start) / 2;          
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > arr[start])   //stable left
            {
                if(arr[start] <= target && arr[mid] >= target )
                end = mid - 1;
                else
                start = mid + 1;
            }
             else if(arr[mid] < arr[end]) //stable right
             { 
                 if(arr[mid] <= target && arr[end] >= target)
                     start = mid + 1;
                 else 
                     end = mid - 1 ;
             }//[1,3,1,1,1], target = 3;
              else if(arr[mid] == arr[end] && arr[mid] == arr[start]){
                end --;
                start ++;
        }
             else if(arr[mid] == arr[start])
                 start = mid + 1;
             else if(arr[mid] == arr[end])
                 end = mid - 1         }
        return false;
    }
}