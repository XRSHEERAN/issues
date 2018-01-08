//longest increasing subsequence, I used dynamic programming to determine 1. the maximum length of containing curr 2. whether it contains all posible combinations

public int lengthOfLIS(int[] nums) {
    if(nums.length==0)
        return 0;
        int[]dp=new int[nums.length+1];
        dp[0]=1;
        int gmax=1;
        for(int i=1; i< nums.length; i++){
            int pt=0,max=1,temp=nums[i];
            while(pt<i){
                if(nums[pt]<temp)
                    max=max>(dp[pt]+1)?max:(dp[pt]+1);
                    pt++;
            }
            dp[i]=max;
            gmax=gmax>max?gmax:max;
        }
        return gmax;
}

