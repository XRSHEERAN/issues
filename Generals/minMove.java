public class Solution {
    /**
     * @param nums: an array
     * @return: the minimum number of moves required to make all array elements equal
     */
    public int minMoves(int[] nums) {
        // Write your code here
        int min=nums[0];
        for(int i: nums){
            min=Math.min(min,i);
        }
        int diff=0;
        for(int i=0;i<nums.length;++i){
            diff+=(nums[i]-min);//same as decrementing the only number
        }
        return diff;
    }
}
