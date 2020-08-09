/*
113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List <List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         list = new ArrayList<>();
        List <Integer> l = new ArrayList<>();
          hasPath(root,sum,l);
        return list;
    }
    private void hasPath(TreeNode root,int sum,List<Integer> l){
        if(root == null)
            return;       
        if(root.left == null && root.right == null && sum == root.val){
            l.add(root.val);
            list.add(new ArrayList<>(l));
            l.remove(l.size() - 1);
            return;
        }  
        l.add(root.val);
        hasPath(root.left,sum - root.val,l);       
        hasPath(root.right,sum - root.val,l);
        System.out.print(l);
        l.remove(l.size() - 1);
    }
}