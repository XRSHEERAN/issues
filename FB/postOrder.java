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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> ret=new LinkedList<Integer>();
        helper(root,ret);
        return ret;
    }
    private void helper(TreeNode t, List<Integer> ret){
        if(t==null){
            return;
        }
        helper(t.left, ret);
        helper(t.right,ret);
        ret.add(t.val);
    }
}
