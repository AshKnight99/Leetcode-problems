/*
99. Recover Binary Search Tree
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Example 1:
Input: [1,3,null,null,2]
   1
  /
 3
  \
   2

Output: [3,1,null,null,2]
   3
  /
 1
  \
   2
Example 2:
Input: [3,1,4,null,null,2]
  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]
  2
 / \
1   4
   /
  3
Follow up:
A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
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
    TreeNode pre, first, second;
    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(first, second);
        
    }
    //inorder
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        
        if(pre != null && root.val <= pre.val) {
            if(first == null) first = pre;     //notice here
            second = root;
        }
        pre = root;
        
        dfs(root.right);
    }        
    public void swap(TreeNode node1, TreeNode node2){
        if(node1 != null && node2 != null){
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }
}
/*
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
     List<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        TreeNode first = null,second = null;
       // System.out.print(list);
        for(int pos = 0;pos < list.size();pos++){
            if(pos == 0){
                if(list.get(pos).val > list.get(pos + 1).val)
                    first = list.get(pos);
            } 
            else if(pos == list.size() - 1){
                if(list.get(pos).val < list.get(pos - 1).val)
                    second = list.get(pos);
            }else {
                if(list.get(pos).val > list.get(pos + 1).val || list.get(pos).val < list.get(pos - 1).val){
                    if(first == null)
                        first = list.get(pos);
                    else 
                        second = list.get(pos);                   
                }
            }
        }        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;    
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    } 
}
*/
