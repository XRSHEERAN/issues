/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
     private TreeNode prev, n0, n1;
     
    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        helper(root);
        if(n0!=null){
            int temp=n0.val;
            n0.val=n1.val;
            n1.val=temp;
        }
        return root;
    }
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=null && n0==null && root.val<prev.val){
            n0=prev;
        }
        if(n0!=null && root.val<prev.val){
            n1=root;
        }
        prev=root;
        helper(root.right);
    }
}
