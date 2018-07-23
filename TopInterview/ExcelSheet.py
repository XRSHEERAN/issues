class Solution:
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        ret,base=(0,0)
        for i in range(len(s)-1,-1,-1):
            c=s[i]
            ret+=(ord(c)-ord('A')+1)*(26**base)
            base+=1
        return ret
