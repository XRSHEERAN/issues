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
     * @param root: 
     * @return: the length of the longest path where each node in the path has the same value
     */
     private int max;
    public int longestUnivaluePath(TreeNode root) {
        // Write your code here
        max=0;
        helper(root.val,root);
        return max-1;
    }
    private int helper(int prev, TreeNode r){
        if(r==null){
            return 0;
        }
        //System.out.println(r.val+","+prev);
        if(prev!=r.val){
            max=Math.max(helper(r.val,r.left)+helper(r.val,r.right)+1,max);
            return 0;
        }
        
        int l=helper(prev,r.left);
        int rg=helper(prev,r.right);
        max=Math.max(1+l+rg,max);
        return (1+Math.max(l,rg));
    }
}
