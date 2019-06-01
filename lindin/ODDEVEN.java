/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: a singly linked list
     * @return: Modified linked list
     */
    public ListNode oddEvenList(ListNode head) {
        // write your code here
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head,eve=head.next;
        while(curr!=null && curr.next!=null){
            ListNode temp=curr.next;
            curr.next=temp.next;
            if(temp!=null && temp.next!=null){
                temp.next=temp.next.next;
            }
            if(curr.next!=null)
                curr=curr.next;
        }
        curr.next=eve;
        return head;
    }
}
