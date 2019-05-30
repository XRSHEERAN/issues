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
     * @param root: root of the given tree
     * @return: whether it is a mirror of itself 
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        if(root.left==null || root.right==null){
            return false;
        }
        Queue<TreeNode> lft=new LinkedList<TreeNode>(), rgt=new LinkedList<TreeNode>();
        lft.add(root.left);
        rgt.add(root.right);
        while(!lft.isEmpty() || !rgt.isEmpty()){
            if(lft.isEmpty() || rgt.isEmpty()){
                return false;
            }
            
            TreeNode l=lft.poll(),r=rgt.poll();
            if(l==null && r==null){
                continue;
            }
            else if(l==null || r==null){
                return false;
            }
            else if(l.val!=r.val){
                return false;
            }
            else{
                lft.add(l.left);
                rgt.add(r.right);
                lft.add(l.right);
                rgt.add(r.left);
            }
        }
        return true;
    }
}
