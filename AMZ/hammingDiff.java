public class Solution {
    /**
     * @param x: an integer
     * @param y: an integer
     * @return: return an integer, denote the Hamming Distance between two integers
     */
    public int hammingDistance(int x, int y) {
        // write your code here
        int count=0;
        while(x>0 || y>0){
            int temp=(x&1)^(y&1);//1 if different
            count+=temp;
            x>>=1;
            y>>=1;
        }
        return count;
    }
}
