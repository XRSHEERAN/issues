class Solution:
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        mapping={}
        for i in A:
            for j in B:
                temp=i+j
                if temp not in mapping:
                    mapping[temp]=1
                else:
                    mapping[temp]+=1
        mapping2={}
        for i in C:
            for j in D:
                temp=i+j
                if temp not in mapping2:
                    mapping2[temp]=1
                else:
                    mapping2[temp]+=1
        count=0
        for i in mapping:
            if -1*i in mapping2:
                count+=mapping[i]*mapping2[-1*i]
        
        return count
