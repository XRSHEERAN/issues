/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode headg;
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        headg=head;
        ListNode prev=head;
        while(head!=null){
            if(head.val<prev.val)
                helper(prev,head);
            prev=head;
            head=head.next;
        }
        return headg;
    }
    public void helper(ListNode end, ListNode findee){
        end.next=findee.next;
        if(findee.val<=headg.val){ //should be les or equal to include all cases
            ListNode temp=headg;
            headg=findee;
            findee.next=temp;
            return;
        }
        ListNode prev=null,curr=headg;
        while(true){
            if(findee.val>curr.val){
                prev=curr;
            }
            else{
                if(prev==null){
                    
                    return;
                }
                ListNode temp=prev.next;
                prev.next=findee;
                findee.next=temp;
                return;
            }
            curr=curr.next;
        }
    }
}
