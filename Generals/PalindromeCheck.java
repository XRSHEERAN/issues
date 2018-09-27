/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int latterIndex = count / 2;
        if (count % 2 != 0) {
            latterIndex++;
        }
        ListNode laterH = head;
        count = 0;
        while (count != latterIndex) {
            count++;
            laterH = laterH.next;
        }

        ListNode pre = laterH;
        ListNode cur = laterH;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        laterH.next = null;
        while (pre != null){
            if(head.val != pre.val)
                return false;
            head = head.next;
            pre = pre.next;
        }
        return true;

    }
}
