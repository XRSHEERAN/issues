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
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
     private int[] min;
    public int findSecondMinimumValue(TreeNode root) {
        // Write your code here
        if(root==null){
            return -1;
        }
        return helper(root,root.val);
        
    }
    private int helper(TreeNode root, int min){
        if(root.val!=min){
            return root.val;//min is the current smallest
        }
        else if(root.left==null && root.val==min){
            return -1;
        }
        else{
            //no null conditions
            int left=helper(root.left,root.val);
            int right=helper(root.right,root.val);
            if(left==-1 && right==-1){
                return -1;//all values are the same
            }
            else{
                return (left<0)? right:left;
            }
        }
    }
}
