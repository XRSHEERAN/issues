//Intuitive but slow...
class Solution {
    public void rotate(int[][] matrix) {
        int length =matrix.length,round=length/2;
        for(int i=0;i<=round;i++){
            for(int j=i;j<i+length-1;j++){
                helper(matrix,i,j);
            }
            length-=2;
        }
    }
    // 1:i,j 2:i+(j-i),n-i 3:n-i,n-i-(j-i) 4:n-i-(j-i),i
    public void helper(int[][] matrix,int i, int j){
        int n=matrix.length-1;
        swap(matrix,i,j,j,n-i);
        swap(matrix,i,j,n-i,n-j);
        swap(matrix,i,j,n-j,i);
    }
    public void swap(int[][]matrix, int a,int b, int c, int d){
        int temp=matrix[c][d];
        matrix[c][d]=matrix[a][b];
        matrix[a][b]=temp;
    }
}
