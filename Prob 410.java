/*
410. Split Array Largest Sum
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
Note:
If n is the length of array, assume the following constraints are satisfied:
1 ? n ? 1000
1 ? m ? min(50, n)
Examples:
Input:
nums = [7,2,5,10,8]
m = 2
Output:
18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
*/
class Solution {
    public int splitArray(int[] weights, int m) {
  
        if(weights.length == 0)
            return 0;
        int sum = Arrays.stream(weights).sum();
        int start = Arrays.stream(weights).max().getAsInt(), end = sum;
        int mid = 0;
        int res = start;
        while(start <= end){
            mid = start + (end - start) / 2;
            if(possible(weights,mid,m)){
                res = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return res;
    }
    public boolean possible(int arr[],int max,int split){
        int i = 0, count = 1,sum = 0;        //count = 1 as we consider we are on first day 
        while(i < arr.length){
            if(arr[i] + sum <= max)
                sum += arr[i];
            else{
                sum = arr[i];
                count ++;          
            }
            i++;
        }
        return count <= split;
    }    
    
}
