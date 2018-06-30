class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> colNum=new HashSet<Integer>();        
        Set<Integer> rowNum=new HashSet<Integer>();
        int row=matrix.length;
        int col=matrix[0].length;
        
        for(int i = 0;i < row; i++){
            for(int j = 0;j < col; j++){
                if(matrix[i][j]==0){
                    rowNum.add(i);
                    colNum.add(j);
                }
            }
        }
        for(int i : rowNum){
            for(int j=0;j<col;j++){
                matrix[i][j]=0;
            }
        }
        for(int i : colNum){
            for(int j=0;j<row;j++){
                matrix[j][i]=0;
            }
        }
    }
}
