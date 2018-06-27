class Solution:
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height)==0 or len(height)==1:
            return 0
        hgt,total,store=(height[0],0,0)
        
        for i in height:
            if hgt<=i:
                hgt=i
                total+=store
                store=0
            store+=(hgt-i)
            
        hgt,store=(height[len(height)-1],0)
        
   
        
        for i in range(len(height)-1,-1,-1):
            if hgt<height[i]:
                hgt=height[i]
                total+=store
                store=0
            store+=(hgt-height[i])
        
        return total
                
