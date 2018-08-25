class Solution {
    public int[][] generateMatrix(int n) {
        int[][] board=new int[n][n];
        
        if (n==0)
            return board;
        int curr=1;
        while(n>0){
            int stp=(board.length-n)/2,count=0,len=stp;
            while(count<n){
                board[len][stp+count]=curr++;
                count++;
            }
            stp=stp+count-1;
            count=1;
            while(count<n){
                board[len+count][stp]=curr++;
                count++;
            }
            len=len+count-1;
            count=1;
            while(count<n){
                board[len][stp-count]=curr++;
                count++;
            }
            stp=stp-count+1;
            count=1;
            while(count<n-1){
                board[len-count][stp]=curr++;
                count++;
            }
            n-=2;
        }
        return board;
    }
}
