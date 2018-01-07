class Solution {
    //longest increasing subsequence, I used dynamic programming to determine 1. the maximum length of containing curr 2. whether it contains all posible combinations
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int[]dp=new int[nums.length+1];
        dp[0]=1;
        int gmax=1;
        for(int i=1; i< nums.length; i++){
            int pt=0,max=1,temp=nums[i];
            while(pt<i){
                if(nums[pt]<temp)
                    max=max>(dp[pt]+1)?max:(dp[pt]+1);
                pt++;
            }
            dp[i]=max;
            gmax=gmax>max?gmax:max;
        }
        return gmax;
    }
    
    //serialization: Solutiion with recurssive preorder search; Most reasonable searching alg
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    private void traverse(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(node.val+",");
            traverse(node.left, sb);
            traverse(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    //use queue to get rid of used strings
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals("null")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
    
    
}
