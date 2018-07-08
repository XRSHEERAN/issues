class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int maxN=0;
        
        int count=1;
        
        while(count<prices.length){
            if(prices[count]>prices[count-1])
                maxN+=(prices[count]-prices[count-1]);
            count++;
        }
        
        return maxN;
    }
}
