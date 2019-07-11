public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> ret=new LinkedList<>();
        ret.add(new LinkedList<Integer>());
        helper(nums,0,new LinkedList<Integer>(),ret);
        return ret;
    }
    private void helper(int[] nums, int pos,List<Integer> curr, List<List<Integer>> ret){
        for(int i=pos;i<nums.length;++i){
            if(i>pos && nums[i]==nums[i-1]){
                continue;//makes sure that only include same number once
            }
            curr.add(nums[i]);
            ret.add(new LinkedList<Integer>(curr));
            helper(nums,i+1,curr,ret);
            curr.remove(curr.size()-1);
        }
    }
}
