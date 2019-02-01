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
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        ret=0;
        uniHelper(root,root.val);
        return ret-1;
    }
    private int ret;
    private int uniHelper(TreeNode curr, int prev){
        if(curr==null){
            return 0;
        }
        int lft,rgt;
        if(curr.val==prev){
            lft=uniHelper(curr.left,prev);
            rgt=uniHelper(curr.right,prev);
            ret=Math.max(ret,lft+rgt+1);
            return Math.max(rgt,lft)+1;//return the current max path
        }
        else{
            lft=uniHelper(curr.left,curr.val);
            rgt=uniHelper(curr.right,curr.val);
            ret=Math.max(ret,lft+rgt+1);
            return 0;
        }
    }
}
