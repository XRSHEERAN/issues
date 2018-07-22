class Solution {
    public int findPeakElement(int[] nums) {
        
        /*
        General: go to the mid, check it and it's next element
        Conditions: 
        1. if next is less, a peak is in the left half (includes mid) -> if the prev is less, mid is peak; else current node is decreased from another number, which is the peak.
        2. Vice versa, if next is greater, than there ia a peak in the right half (include mid)
        */
        //this line in case there is such an input, doesn't matter though
        if(nums.length==0 || nums==null)
            return -1;
        
        int left=0, right=nums.length-1, mid=nums.length/2;
        
        if(left==right){
            return 0;
        }
        //now the nums is guarenteed to have two or three elements at least
        while(true){
            //only two numbers left
            if(left+1==right){
                return (Math.max(nums[left],nums[right])==nums[left])? left:right;
            }
            mid=(left+right)/2;
            
            //there is not a chance they are equal
            if(nums[mid]<nums[mid+1])
                left=mid;
            else
                right=mid;
        }
    }
}
