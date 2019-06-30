public class Solution {
    /**
     * @param nums: an array
     * @return: the Next Greater Number for every element
     */
     
    public int[] nextGreaterElements(int[] nums) {
        // Write your code here
        //track index and smaller numbers
        if(nums.length==0){
            return nums;
        }
        int curr=0;
        Stack<Integer> smaller=new Stack<>();
        smaller.push(0);//push in first index
        int[] ret=new int[nums.length];
        ret[0]=-1;
        //two rounds
        for(int i=1;i<nums.length;++i){
            if(nums[curr]<nums[i]){
                curr=i;
            }
            while(!smaller.isEmpty() && nums[smaller.peek()]<nums[i]){
                //update all previous smaller
                ret[smaller.pop()]=nums[i];
            }
            smaller.push(i);
        }
        //only largest left
        if(smaller.size()==1){
            ret[curr]=-1;
        }
        else{
            //second round, top of stack is the smallest
            for(int i=0;i<nums.length;++i){
                while(!smaller.isEmpty() && nums[smaller.peek()]<nums[i]){
                    System.out.println(smaller.peek());
                    ret[smaller.pop()]=nums[i];
                }
                if(smaller.peek()<=i){
                    while(!smaller.isEmpty()){
                        ret[smaller.pop()]=-1;
                    }
                    break;
                }
            }
        }
        return ret;
    }
}
