class Solution{
    // For this question, BST has the nice feature of having all less vals on the left and thus we can track the closest value step be step
    
    public int closest(TreeNode node,int tar){
        if(node.val==null)
            return 0;
        int min=INTEGER.MAX_VALUE,ret;
        while(node!=null){
            int temp=node.val;
            if(temp>tar){
                if(temp-tar<min){
                    min=temp-tar;
                    ret=temp;
                }
                node=node.left;
            }
            else if(temp<tar){
                if(tar-temp<min){
                    min=tar-temp;
                    ret=temp;
                }
                node=node.right;
            }
            else
                return temp;
        }
        return ret;
    }
}
