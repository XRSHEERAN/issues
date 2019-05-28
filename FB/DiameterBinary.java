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
     * @param root: a root of binary tree
     * @return: return a integer
     */
     private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        max=0;
        helper(root);
        return max-1;
    }
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int lft=helper(root.left),rgt=helper(root.right);
        max=Math.max(max,lft+rgt+1);
        return Math.max(lft,rgt)+1;
    }
}
