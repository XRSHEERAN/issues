class Solution {
    public int longestArithSeqLength(int[] A) {
        int[][] dp=new int[A.length+1][A.length+1];//start with i and end with j
        int ret=2;
        for(int i=0;i<A.length;++i){
            dp[i][i]=1;
            for(int j=i+1;j<A.length;++j){
                int diff=A[j]-A[i];
                dp[i][j]=2;
                for(int k=i-1;k>-1;--k){
                    if((A[i]-A[k])==diff){
                        dp[i][j]=Math.max(dp[i][j],dp[k][i]+1);
                    }
                }
                ret=Math.max(ret,dp[i][j]);
            }
        }
        return ret;
    }
}
