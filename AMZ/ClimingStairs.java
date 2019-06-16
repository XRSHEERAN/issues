public class Solution {
    /**
     * @param cost: an array
     * @return: minimum cost to reach the top of the floor
     */
    public int minCostClimbingStairs(int[] cost) {
        // Write your code here
        if(cost.length<=2){
            return cost[cost.length-1];
        }
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;++i){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[cost.length-2],dp[cost.length-1]);
    }
}
