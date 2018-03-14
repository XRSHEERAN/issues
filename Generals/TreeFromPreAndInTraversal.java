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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length || preorder.length==0)
            return null;
        return helper(preorder,inorder, 0, 0, inorder.length-1);
    }
    //include instrt and inend
    public TreeNode helper(int[] pre, int[] in, int prestrt, int instrt, int inend){
        if(instrt>inend)
            return null;
        if(instrt==inend)
            return new TreeNode(in[instrt]);
        int key=pre[prestrt],bp=instrt;
        TreeNode root=new TreeNode(key);
        while(in[bp]!=key)
            bp++;
        root.left=helper(pre, in, prestrt+1,instrt,bp-1);
        root.right=helper(pre,in,prestrt+bp-instrt+1,bp+1,inend);
        return root;
    }
}
