public class Solution {
    /**
     * @param nums: a list of integers
     * @param m: an integer
     * @return: return a integer
     */
    public int splitArray(int[] nums, int m) {
        int l=0,r=0;
        for(int n:nums){
            l=Math.max(n,l);
            r+=n;
        }//have two bounds 
        if(m==1){
            return r;
        }
        //starting search
        while(l<r){
            int curr=0,count=1,mid=(l+r)/2;
            boolean valid=true;
            for(int n:nums){
                if(curr+n>mid){
                    curr=n;
                    ++count;
                    if(count>m){
                        valid=false;
                        break;
                    }
                }
                else{
                    curr+=n;
                }
            }
            if(valid){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}
