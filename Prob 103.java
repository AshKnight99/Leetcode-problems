/*
103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        if(root == null)
            return new ArrayList<>();
        List <List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        l.add(root.val);
        list.add(l);
        q.add(root);
        boolean reverse = true;
        while(!q.isEmpty()){
            int size = q.size();            
            l = new ArrayList<>();
            for(int i = 0;i < size;i++){
            TreeNode node = q.poll();
            if(node.left != null){
                l.add(node.left.val);
                q.offer(node.left);
            }
            if(node.right != null){
                l.add(node.right.val);
                q.offer(node.right);
            }
            }
            if(reverse)
                Collections.reverse(l);
            if(!l.isEmpty())
                list.add(l);            
            reverse = !reverse;
        }
        return list;   
    }
}