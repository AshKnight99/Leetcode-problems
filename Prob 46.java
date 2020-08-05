/*
46. Permutations
Given a collection of distinct integers, return all possible permutations.
Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
     list = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        helper(nums,visited,0,new ArrayList<Integer>());
        return list;
    }
    public void helper(int nums[],boolean visited[],int index,List<Integer> l){
        if(index == nums.length){
            list.add(new ArrayList<Integer>(l));
            return;
        }        
           for(int i = 0;i < nums.length;i++){ 
            if(!visited[i]){
            visited[i] = true;
            l.add(nums[i]);
            helper(nums,visited,index + 1,l);
            visited[i] = false;
            l.remove(l.size() - 1); 
              }
           }        
    }