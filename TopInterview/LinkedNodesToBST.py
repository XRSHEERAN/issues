# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        
        if not head:
            return None
        
        if head.next==None:
            return TreeNode(head.val)
        if head.next.next==None:
            rgt=TreeNode(head.next.val)
            root=TreeNode(head.val)
            root.right=rgt
            return root
        mid=self.splitHelperCool(head)
        ret=TreeNode(mid.val)
        ret.left=self.sortedListToBST(head)        
        ret.right=self.sortedListToBST(mid.next)
        return ret

        
    #traditional way, size is the hald list size
    def splitHelperTradition(self,head,size):
        ret=head
        brk=ret
        for i in range(size):
            brk=ret
            ret=ret.next
        brk=None
        return ret
            
    def splitHelperCool(self,head):
        slow=head
        fst=head
        brk=slow
        while fst and fst.next:
            brk=slow
            slow=slow.next
            fst=fst.next.next
       
        brk.next=None
        return slow
