class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        (minN,maxN)=(sys.maxsize,0)
                
        for i in prices:
            if i<minN:
                minN=i
            else:
                maxN=i-minN if maxN < (i-minN) else maxN
        
        return maxN
