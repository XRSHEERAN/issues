# Comments

## 1. BST Version
#### This question is just a reminder of the bst properties: large on right, small on left. Thats it.

## Java
```JAVA
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val>=p.val && root.val<=q.val) || (root.val>=q.val && root.val<=p.val))
            return root;
        else if(root.val<=p.val && root.val<=q.val)
            return lowestCommonAncestor(root.right, p, q);
        return lowestCommonAncestor(root.left, p, q);
    }
}
```

## Python
```PYTHON
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if (root.val >= p.val and root.val<=q.val) or (root.val <= p.val and root.val>=q.val):
            return root
        elif root.val>p.val and root.val >q.val:
            return self.lowestCommonAncestor(root.left,p,q)
        else:
            return self.lowestCommonAncestor(root.right,p,q)
```
## 2. BT Version

#### Few changes, returning the findings bottom up; return root if and only if both are find and will keep it returning since no left/right nodes will be found.

```JAVA
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val) return root;
        TreeNode lft=lowestCommonAncestor(root.left,p,q);
        TreeNode rgt=lowestCommonAncestor(root.right,p,q);
        if(lft!=null && rgt!=null)
            return root;
        else if(lft==null)
            return rgt;
        else
            return lft;
    }
}
```
