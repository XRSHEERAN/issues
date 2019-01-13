import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<2 || k==1)
            return nums;
        int[] ret=new int[nums.length-k+1];
        int ptr=0;
        Deque<Integer> dq=new ArrayDeque<Integer>();
        
        for(int i=0;i<k-1;++i){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.add(i);
        }
        for(int i=k-1;i<nums.length;++i){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1)
                dq.pollFirst();
            dq.add(i);
            ret[ptr]=nums[dq.peekFirst()];
            ++ptr;
        }
        return ret;
    }
}