/*
347. Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]
Note:
You may assume k is always valid, 1 ? k ? number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0)
            return nums;
        HashMap <Integer,Integer> map = new HashMap <>();
        for(int c : nums)
            map.put(c,map.getOrDefault(c,0) + 1);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
          maxheap.addAll(map.keySet());
        //System.out.print(maxheap);
        int arr[] = new int [k];
        int j = 0;
        while(k > 0){
            arr[j ++] = maxheap.poll();
            k --;
        }
        return arr;
        
    }