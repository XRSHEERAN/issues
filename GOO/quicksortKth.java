public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        return part(0,nums.length-1,nums,n-1);
        
    }
    private void swap(int a, int b, int[] nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    private int part(int lft, int rgt, int[] nums,int k){
        int ptr=(lft+rgt)/2;
        swap(lft,ptr,nums);
        ptr=lft;
        
        for(int i=lft+1;i<=rgt;++i){
            if(nums[ptr]<=nums[i]){
                ++lft;
                swap(lft,i,nums);
            }
        }
        if(lft==k){
            return nums[ptr];
        }
        else if(lft>k){
            swap(lft,ptr,nums);
            return part(ptr,lft-1,nums,k);
        }
        else{
            return part(lft+1,rgt,nums,k);
        }
    }
}
