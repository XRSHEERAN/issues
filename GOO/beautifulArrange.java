public class Solution {
    /**
     * @param n: the number of integers
     * @param k: the number of distinct integers
     * @return: any of answers meet the requirment
     */
    public int[] constructArray(int n, int k) {
        // Write your code here
        int[] ret=new int[n];
        //1.use first k+1 numbers to construct k differences,k+1<=n
        for(int i=0;i<k+1;++i){
            ret[i]=(i%2==0)?1+i/2 : k+1-i/2;//even odd intersections
        }
        //2.put the rest of numbers in order so that the difference is 1
        for(int i=k+1;i<n;++i){
            ret[i]=i+1;//the diff to previous number is at most k/2
        }
        //thus total diff is k
        return ret;
    }
}
