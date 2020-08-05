/*
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
class Solution {
    Set <List<Integer>> set;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        set = new HashSet<>();
        Arrays.sort(nums);
        helper(nums,new ArrayList<Integer>(),0);
        return new ArrayList<List<Integer>>(set);
    }
    public void helper(int nums[],List<Integer>l,int index){
        if(index == nums.length){
            set.add(new ArrayList<>(l));
            return;
        }
        helper(nums,l,index + 1);
        l.add(nums[index]);
        helper(nums,l,index + 1);
        l.remove(l.size() - 1);
    }
}
