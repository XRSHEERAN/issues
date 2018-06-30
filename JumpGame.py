class Solution:
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        counter=0
        for i in range(len(nums)):
            if counter==-1:
                return False
            if i!=len(nums)-1 and (counter==0 and nums[i]==0):
                return False
            counter=max(counter,nums[i])
            counter-=1
        return True
            
