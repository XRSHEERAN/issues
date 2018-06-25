/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null)
            return null;
        ListNode head=null,curr;
        List<Integer> currList=new ArrayList<Integer> ();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<lists.length;i++){
            if(lists[i]==null)
                continue;
            if(lists[i].val<min){
                min=lists[i].val;
                currList=new ArrayList<Integer>();
                currList.add(i);
            }
            else if(lists[i].val==min)
                currList.add(i);
        }
        if(currList.size()==0){
            System.out.println("ddddd");
            return null;
        }
        
        head=new ListNode(lists[currList.get(0)].val);
        lists[currList.get(0)]=lists[currList.get(0)].next;
        curr=head;
        for(int i=0;i<currList.size();i++){
            int temp=currList.get(i);
            while(lists[temp]!=null && lists[temp].val==min){
                curr.next=new ListNode(lists[temp].val);
                curr=curr.next;
                lists[temp]=lists[temp].next;
            }
        }
        curr.next=mergeKLists(lists);
        return head;
    }
}
