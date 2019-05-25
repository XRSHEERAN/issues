public class Solution {
    /**
     * @param prices: a list of integers
     * @param fee: a integer
     * @return: return a integer
     */
    public int maxProfit(int[] prices, int fee) {
        // write your code here
        int[] buy=new int[prices.length], sell=new int[prices.length];
        buy[0]=-1*prices[0];
        sell[0]=0;
        for(int i=1;i<prices.length;++i){
            buy[i]=Math.max(sell[i-1]-prices[i],buy[i-1]);
            sell[i]=Math.max(sell[i-1],prices[i]+buy[i-1]-fee);
        }
        return sell[prices.length-1]>0?sell[prices.length-1]:0;
        
    }
}
