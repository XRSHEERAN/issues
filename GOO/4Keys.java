public class Solution {
    /**
     * @param N: an integer
     * @return: return an integer
     */
    public int maxA(int N) {
        // write your code here
        if(N<3){
            return N;
        }
        int[] dp=new int[N+1];//stores the max num of A produced by i strokes
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=N;++i){
            dp[i]=i;
            for(int j=1;j<i-2;++j){
                dp[i]=Math.max(dp[i],dp[j]*(i-j-1));//the number of pastes
            }
        }
        return dp[N];
    }
}
