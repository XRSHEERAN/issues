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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root==null){
            return "#";
        }
        Queue<TreeNode> level=new LinkedList<TreeNode>();
        StringBuilder ret=new StringBuilder();
        level.add(root);
        while(!level.isEmpty()){
            Queue<TreeNode> tempQ=new LinkedList<TreeNode>();
            int valid=0;
            while(!level.isEmpty()){
                TreeNode temp=level.poll();
                if(temp==null){
                    ret.append('#');
                    tempQ.add(null);
                    tempQ.add(null);
                }
                else{
                    ret.append(temp.val);
                    tempQ.add(temp.left);
                    tempQ.add(temp.right);
                    if(temp.left!=null){
                        ++valid;
                    }
                    if(temp.right!=null){
                        ++valid;
                    }
                }
                ret.append(',');
            }
            if(valid==0){
                break;
            }
            level=tempQ;
        }
        return ret.toString().substring(0,ret.length()-1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data=="#"){
            return null;
        }
        String[] dataA=data.split(",");
        TreeNode ret= new TreeNode(Integer.parseInt(dataA[0]));
        helper(ret,0,dataA);
        return ret;
    }
    public void helper(TreeNode nd, int level, String[] arr){
        if(nd==null){
            return;
        }
        int lft=level*2+1,rgt=level*2+2;
        if(lft>=arr.length){
            return;
        }
        if(!arr[lft].equals("#")){
            nd.left=new TreeNode(Integer.parseInt(arr[lft]));
            helper(nd.left,lft,arr);
        }
        if(!arr[rgt].equals("#")){
            nd.right=new TreeNode(Integer.parseInt(arr[rgt]));
            helper(nd.right,rgt,arr);
        }
    }
}
