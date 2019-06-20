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
     * @param root: the root
     * @return: the minimum absolute difference between values of any two nodes
     */
    public int getMinimumDifference(TreeNode root) {
        // Write your code here
        prev=-1;
        min=Integer.MAX_VALUE;
        preorder(root);
        return min;
    }
    private int prev,min;
    public void preorder(TreeNode root){
        if(root==null)
            return;
        preorder(root.left);
        if(prev>=0){
            min=Math.min(root.val-prev,min);
        }
        prev=root.val;
        preorder(root.right);
    }
    
}
