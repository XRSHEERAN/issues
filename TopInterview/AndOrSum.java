/*
The max/min AND sums are: largest, and all
OR sums are: or all, smallest
*/
public long getSum(int n, int[] nums) {
        // write your code here
        if(nums.length==0){
            return 0;
        }
        long xA=nums[0],iA=nums[0],xO=nums[0],iO=nums[0];
        for(int i=1;i<nums.length;++i){
            xA=Math.max(xA,nums[i]);
            iA=iA&nums[i];
            xO=xO|nums[i];
            iO=Math.min(iO,nums[i]);
        }
        return xA+iA+xO+iO;
    }
