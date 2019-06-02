public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        // Write your code here
        if(nums.length==0){
            return new LinkedList<String>();
        }
        List<String> lst=new LinkedList<>();
        int strt=nums[0],end=nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i]-nums[i-1]==1){
                end=nums[i];
            }
            else{
                lst.add(rangeMaker(strt,end));
                strt=nums[i];
                end=nums[i];
            }
        }
        lst.add(rangeMaker(strt,end));
        return lst;
    }
    private String rangeMaker(int a, int b){
        if(a==b){
            return ""+a;
        }
        else{
            return a+"->"+b;
        }
    }
}
