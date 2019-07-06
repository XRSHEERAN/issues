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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> ret=new LinkedList<>();
        helper(root,ret,k1,k2);
        return ret;
    }
    private void helper(TreeNode curr, List<Integer> l, int a, int b){
        if(curr==null){
            return;
        }
        helper(curr.left,l,a,b);
        if(curr.val>=a && curr.val<=b){
            l.add(curr.val);
        }
        helper(curr.right,l,a,b);
    }
}
