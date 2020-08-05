/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        helper(n,k,new ArrayList<Integer>());
        return list;
    }
    public void helper(int n,int index,List<Integer> l){
        if(index == 0){
            list.add(new ArrayList<Integer>(l));
            return;
        }
        for(int i = n;i >= 1;i -- ){
            l.add(i);
            helper(i - 1,index - 1,l);
            l.remove(l.size() - 1);
        }
    }
}