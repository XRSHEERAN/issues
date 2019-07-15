public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int[] count=new int[nums.length];
        int lc=0,rc=0;
        if(nums.length<2){
            return nums[0];
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]==1){
                ++lc;
                count[i]=Math.max(count[i],lc);
            }
            else{
                lc=0;
            }
        }
        for(int i=0;i<nums.length;++i){
            
            int temp=nums.length-i-1;
            if(nums[temp]==1){
                ++rc;
                count[temp]=Math.max(count[temp],rc);
            }
            else{
                rc=0;
            }
        }
        int max=0;
        if(nums[0]==0){
            max=count[1]+1;
        }
        if(nums[nums.length-1]==0){
            max=Math.max(count[nums.length-2]+1,max);
        }
        for(int i=1;i<nums.length-1;++i){
            if(nums[i]==0){
                max=Math.max(max,count[i-1]+1+count[i+1]);
            }
        }
        return max;
    }
}
