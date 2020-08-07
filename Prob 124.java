/*
124. Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]
       1
      / \
     2   3
Output: 6
Example 2:
Input: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
Output: 42
*/
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        maxDfs(root);
        return ans;        
    }
    public int maxDfs(TreeNode root){
         if(root == null)
            return 0;        
        int l = Math.max(maxDfs(root.left),0);
        int r = Math.max(maxDfs(root.right),0);         
        int temp = Math.max(l , r) + root.val;
        int res = Math.max(temp,(l + r + root.val));
        ans = Math.max(ans,res);
        return temp;
    }
}