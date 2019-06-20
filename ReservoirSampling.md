#### Summary
This is an O(N) time, constant space random sampling. Every draw has the same possibility。

#### Proof
1st draw: p(0)=1

2nd: p(0)=1*(1-1/2)=1/2 (the chance of staying in previous status) p(1)=1/2

3rd: p(0)=p(1)=1/2*(1-1/3)=1/3, p(2)=1/3

...

nth: p(n-1)=1/n, p(0)=p(1)=...=1/(n-1)*(1-1/n)=1/n

#### Code
```JAVA
class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
        //target must exist
        //using Reservoir sampling
        int c=0,ret=-1;
        Random rnd=new Random();
        for(int i=0;i<this.nums.length;++i){
            if(nums[i]!=target){
                continue;
            }
            ++c;
            if(rnd.nextInt(c)==0){
                ret=i;
            }
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
```
