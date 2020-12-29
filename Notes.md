[Algorithm Ref](https://www.programcreek.com/2013/08/leetcode-problem-classification/)
## KMP
#### Algorithm
- construct pre/post match table by matching itself
- use the table to reuse match part (while no match, continue shrink the matched string)
```
function repeatedSubstringPattern(s: string): boolean {
    let tbl:number[] =[0]; // initial for postiion 0 is 0
    // match longest common prefix and postfix
    if(s.length<2){
        return false;
    }
    for(let i=1;i<s.length;++i){
        // starting from position 1
        let curr = tbl[i-1];//previous string matched length, which is also the index of first check
        let mat = s[i];
        if(s[curr] == s[i]){
            tbl.push(curr+1);
        }else{
            // kmp matching loop
            while(curr>0){
                curr = tbl[curr-1]; //  shrink the reusable matched string
                if(s[curr] == mat){
                    tbl.push(curr+1);
                    break;
                }
            }
            if(!tbl[i]){
                tbl.push(0);
            }
        }
    }
    // math trick, is the diff length of the two fixes are dividable, then we are sure that this diff is repeating in the string, because the prefix and post fix can continue the overlap mapping until all lengths are ful filled. the difference is the length of the minimum pattern
    let diff = s.length - tbl[s.length-1];
    if(tbl[s.length-1]!=0 && s.length%diff==0){
        return true; // divided, can match the whole string
    }
    return false;
};
```

## Racing
#### Slow and fast pointer
```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null){
            return false;
        }
        // fast and slow pointers, the faster one will always move to the slower one as the distance is decreased by 1
        ListNode slow=head, fast = head.next.next;
        while(slow!=fast){
            if(fast==null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;// left the loop with equal, loop detected
    }
}
```
