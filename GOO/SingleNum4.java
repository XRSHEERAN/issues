public class Solution {
    /**
     * @param nums: The number array
     * @return: Return the single number
     */
    public int getSingleNumber(int[] nums) {
        // Write your code here
        int lft=0,rgt=nums.length-1,mid=nums.length/2;
        while(lft<=rgt){
            if(lft==rgt){
                return nums[lft];
            }
            else if(nums[mid-1]==nums[mid] && mid%2==1){
                lft=mid+1;
            }
            else if(nums[mid-1]==nums[mid] && mid%2==0){
                rgt=mid-2;
            }
            else if(nums[mid]==nums[mid+1] && mid%2==0){
                lft=mid+2;
            }
            else if(nums[mid]==nums[mid+1] && mid%2==1){
                rgt=mid-1;
            }
            else{
                return nums[mid];
            }
            mid=(lft+rgt)/2;
        }
        return -1;
    }
}
