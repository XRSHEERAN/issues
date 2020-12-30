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

#### More sophisticated slow and fast pointer
two rounds solutions:
- first round, determines if there is a circle
- second round, two pointers meet at the starting point of the circle

**Math proof:** first round, assume the length of the distance before reaching circle to be *n*, and the point S and F met to starting point of circle to be e ( note that f ans s meets within one circle, as their difference would be less then one circle and F is stepping in 1 at a time ). Thus, let c be the circle diagram, 2\*(n+e) = n+e+x\*c => n+c = x\*c, which means that two pointers meet at start:

<img src="https://github.com/XRSHEERAN/Algorithms/blob/master/slowfast.jpg" width="1200" height="600" />

```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function detectCycle(head: ListNode | null): ListNode | null {
    // two rounds slow and fast pointer
    if(head == null || head.next == null){
        return null;
    }
    let s= head.next, f= head.next.next;
    while( s != f){
        // end of the list reached, no loop
        if(f === null || f.next === null){
            return null;
        }
        // when both on the loop, f is chasing the s pointer, which is 1 node at a time, thus will always meet s
        s = s.next;
        f = f.next.next;
    }
    // end of second round and restart slow pointer, while decreasing f speed, as (n+e)%c = 0
    s = head;
    // meat at starting position of circle
    while(s!=f){
        s = s.next;
        f = f.next;
    }
    return f;
};
```
