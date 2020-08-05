/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    Set <List<Integer>> set ;
    public List<List<Integer>> subsets(int[] nums) {
        set = new HashSet<>();
        helper(nums,new ArrayList<Integer>(),0);
        return new ArrayList<List<Integer>>(set);
    }
    public void helper(int nums[],List<Integer> l, int index){
        if(index == nums.length){
            set.add(new ArrayList<Integer>(l));
            return;
        }        
        helper(nums,l,index + 1);       
        l.add(nums[index]);        
        helper(nums,l,index + 1);       
        l.remove(l.size() - 1);                
    }
}