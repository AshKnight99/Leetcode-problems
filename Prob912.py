"""
912. Sort an Array
	Given an array of integers nums, sort the array in ascending order.

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
 
"""
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.quicksort(nums, 0, len(nums)-1)
        
    def quicksort(self, arr, start, end):
        
        if start < end and start >= 0 and end <= len(arr)-1:
            pIndex = self.partition(arr, start, end)
            self.quicksort(arr, start, pIndex-1)
            self.quicksort(arr, pIndex+1, end)
        
        return arr
            
    def partition(self, arr, start, end):
        
        pivot = arr[end]
        pIndex = start
        
        for i in range(start, end):
            
            if arr[i] <= pivot:
                temp = arr[i]
                arr[i] = arr[pIndex]
                arr[pIndex] = temp
                pIndex += 1
                
        temp = arr[pIndex]
        arr[pIndex] = pivot
        arr[end] = temp
        
        return pIndex