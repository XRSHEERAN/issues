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
    
    /* In-order successor; Note that this node is in the BST and For BST the left subs are definitely less than the node
    Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

    Note: If the given node has no in-order successor in the tree, return null.*/
    //Tricky
    public TreeNode Successor(TreeNode root, TreeNode searchee){
        TreeNode curr=root,ret=null;
        if(searchee.right!=null){
            ret=searchee.right;
            while(ret.left!=null)
                ret=ret.left;
            return ret;
        }
        
        while(curr!=null){
            if(curr.val>searchee.val){
                ret=curr;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        return ret;
    }
    
    }
    
    
    //number to string :)
    class Solution {
    private String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        int temp,i=0;
        String str="";
        while(num>0){
            temp=num%1000;
            if(temp!=0){
                str=helper(temp)+THOUSANDS[i]+" " +str;
            }
            num/=1000;
            i++;
        }
        return str.trim();
    }
    public String helper(int num){
        if (num == 0)
        return "";
    else if (num < 20)
        return LESS_THAN_20[num] + " ";
    else if (num < 100)
        return TENS[num / 10] + " " + helper(num % 10);
    else
        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }

