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
     * @param root: a root of tree
     * @return: return a integer
     */
     private class pair{
         public int lvl;
         public TreeNode t;
         public pair(int lvl, TreeNode t){
             this.lvl=lvl;
             this.t=t;
         }
     }
    public int findBottomLeftValue(TreeNode root) {
        // write your code here
        Queue<pair> lst=new LinkedList<>();
        lst.add(new pair(1,root));
        int ret=0,curr=0;
        while(!lst.isEmpty()){
            
            pair temp=lst.poll();
            if(temp.t==null){
                continue;
            }
            if(temp.lvl>curr){
                curr=temp.lvl;
                ret=temp.t.val;
            }
            lst.add(new pair(temp.lvl+1,temp.t.left));
            lst.add(new pair(temp.lvl+1,temp.t.right));
            
        }
        return ret;
    }
}
