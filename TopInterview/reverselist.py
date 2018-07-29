# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        lst=[]
        while head:
            lst.append(head.val)
            head=head.next
        if not lst:
            return None
        curr=ListNode(lst.pop())
        head=curr
        while lst:
            curr.next=ListNode(lst.pop())
            curr=curr.next
        return head
