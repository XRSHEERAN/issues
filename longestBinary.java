/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int currMax;
    public int maxPathSum(TreeNode root) {
        currMax=Integer.MIN_VALUE;
        currMax=Math.max(maxPath(root),currMax);
        return currMax;
    }
    public int maxPath(TreeNode curr){
        if(curr==null)
            return 0;
        int lft=Math.max(0,maxPath(curr.left));
        int rgt=Math.max(0,maxPath(curr.right));
        currMax=Math.max(currMax,curr.val+lft+rgt);
        return Math.max(lft,rgt)+curr.val;
    }
}
