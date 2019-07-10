public class Solution {
    /**
     * @param list: The coins
     * @param k: The k
     * @return: The answer
     */
    public int takeCoins(int[] list, int k) {
        // Write your code here
        int lsum=0,rsum=0;
        for(int i=0;i<k;++i){
            lsum+=list[i];
        }
        int ptr=k-1,ret=lsum;
        for(int i=list.length-1;i>=(list.length-k);--i){
            rsum+=list[i];
            lsum-=list[ptr];
            --ptr;
            ret=Math.max(ret,lsum+rsum);
        }
        return ret;
    }
}
