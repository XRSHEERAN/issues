## This I Probably The Hardest
#### For most of my time spent on Leetcode, I am doing DP questions. So I have this solitory file summarize all dynamic programming questions.

* Robery (Ez)
```JAVA
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[]dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            dp[i+1]=dp[i]>(dp[i-1]+nums[i])?dp[i] : (dp[i-1]+nums[i]);
        }
        return dp[nums.length];
    }
}
```
```PYTHON
class Solution:
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0: return 0
        if len(nums)==1: return nums[0]
        dp=[0,nums[0]]
        for i in range(1,len(nums)):
            dp.append(max(dp[i],dp[i-1]+nums[i]))
        return dp[-1]
```
* Robery (hard)
```JAVA
//go through every possible break point; e.g. the circle can only be broken if the node is adjacent.
class Solution {
    public int rob(int[] nums,int strt) {
        
        int[]dp=new int[nums.length];
        dp[0]=0;
        dp[1]=nums[strt++];

        for(int i=1;i<nums.length-1;i++){
            if(strt>=nums.length)
                strt=0;
            dp[i+1]=dp[i]>(dp[i-1]+nums[strt])?dp[i] : (dp[i-1]+nums[strt]);
            strt++;
        }
        return dp[nums.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int maxCash=0;
        for(int i=0;i<nums.length;i++){
            int temp=rob(nums,(i==nums.length-1)?0:i+1);
            maxCash=Math.max(maxCash,temp);
        }
        return maxCash;
    }
}
```
