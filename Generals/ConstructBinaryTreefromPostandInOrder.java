/**
Author: Xianrun Qu
Leetcode tests passed
**/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        if(inorder.length==1){
            return new TreeNode(inorder[0]);
        }
        int mid=postorder[postorder.length-1];
        TreeNode curr=new TreeNode(mid);
        
        int lft=0,rgt=0,ptr=0;
        //find the left tree length
        while(inorder[ptr]!=mid){
            lft++;
            ptr++;
        }
        rgt=inorder.length-lft-1;
        
        if(lft>0){
            int[] tempi=new int[lft];
            System.arraycopy(inorder,0,tempi,0,lft);
            int[] tempp=new int[lft];
            System.arraycopy(postorder,0,tempp,0,lft);
            
            curr.left=buildTree(tempi,tempp);
        }
        
        if(rgt>0){
            int[] tempi=new int[rgt];
            System.arraycopy(inorder,lft+1,tempi,0,rgt);
            int[] tempp=new int[rgt];
            System.arraycopy(postorder,lft,tempp,0,rgt);
            
            curr.right=buildTree(tempi,tempp);
        }
        return curr;
    }
    
}
