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
* Minium Path (Here I use python, which is more challenging)

```PYTHON
class Solution:
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dp=[[grid[0][0]]]
        for i in range(1,len(grid)):
            dp.append([dp[i-1][0]+grid[i][0]]) 
        
        for i in range(1,len(grid[0])):
            dp[0].append(dp[0][i-1]+grid[0][i])
            
        for i in range(1,len(grid[0])):
            for j in range(1,len(grid)):
                dp[j].append((dp[j-1][i]+grid[j][i]) if dp[j-1][i]<dp[j][i-1] else (dp[j][i-1]+grid[j][i]))
                
        return dp[len(grid)-1][len(grid[0])-1]
```

## Max Area

```JAVA
//Top down solution
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int raw=matrix.length;
        int col=matrix[0].length;
        int[][]dpWidth=new int[raw][col];
        
        for(int i=0;i<raw;i++){
            dpWidth[i][0]=(matrix[i][0]=='0')?0:1;
            for(int j=1;j<col;j++){
                dpWidth[i][j]=(matrix[i][j]=='0')?0:dpWidth[i][j-1]+1;
            }
        }
        int arr=0;
        for(int i=0;i<raw;i++){
            for(int j=0;j<col;j++){
                int ht=0;
                int wd=dpWidth[i+ht][j];
                while(ht+i<raw && wd>0){
                    wd=Math.min(wd,dpWidth[i+ht][j]);
                    arr=Math.max(arr,wd*(ht+1));
                    ht++;
                    
                }
            }
        }
        return arr;
    }
}
```
