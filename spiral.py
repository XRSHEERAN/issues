class Solution:
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if len(matrix)==0 or len(matrix[0])==0:
            return []
        raw=len(matrix)
        col=len(matrix[0])
        kSide=min(raw,col)
        round= kSide//2 if kSide%2==0 else kSide//2+1
        
        ret=[]
        add=0
        while(round>0):
            ret.extend(self.ptlSpir(matrix,add,add))
            round-=1
            add+=1
        return ret
        
    def ptlSpir(self,matrix,colnum,rawnum):
        """
        :type matrix: List[List[int]]
        :type rNum: int
        :type cNum: int
        :rtype: list
        """
        raw,col=(len(matrix)-1,len(matrix[0])-1)
        ret=[];
        for i in range(colnum,col-colnum+1):
            ret.append(matrix[rawnum][i])
        for i in range(rawnum+1,raw-rawnum+1):
            ret.append(matrix[i][col-colnum])
        if (raw-rawnum) != rawnum:
            for i in range(col-colnum-1,colnum-1,-1):
                ret.append(matrix[raw-rawnum][i])
        
        if (col-colnum) != colnum:
            for i in range(raw-rawnum-1,rawnum,-1):
                ret.append(matrix[i][colnum])
        return ret
