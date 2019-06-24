public class Solution {
    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        // write you code here
        boolean[] dp=new boolean[x+1];
        if(x==3 || x==7){
            return "YES";
        }
        else if(x<10){
            return "NO";
        }
        dp[3]=true;
        dp[7]=true;
        for(int i=10;i<x+1;++i){
            dp[i]=dp[i-7] || dp[i-3];
        }
        return dp[x] ? "YES" : "NO";
    }
}
