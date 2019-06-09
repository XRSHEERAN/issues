public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return a list of integers
     */
    public List<Integer> findDuplicates(int[] nums) {
        // write your code here
        List<Integer> ret=new LinkedList<>();
        for(int i:nums){
            int temp=nums[Math.abs(i)-1];//the number within n
            if(temp<0){
                ret.add(Math.abs(i));//add one time as only appear twice
            }
            else{
                nums[Math.abs(i)-1]=-1*temp;
            }
        }
        return ret;
    }
}
