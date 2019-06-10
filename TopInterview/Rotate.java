public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        k%=nums.length;
        if(k==0){
            return nums;
        }
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
        return nums;
    }
    private void reverse(int[] nums,int l,int r){
        for(int i=l;i<=(l+r)/2;++i){
            int temp=nums[i];
            nums[i]=nums[r-(i-l)];
            nums[r-(i-l)]=temp;
        }
    }
}
