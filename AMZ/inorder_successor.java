ven a binary search tree and a node in it, find the in-order successor of that node in the BST.

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
