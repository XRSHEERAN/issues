//The tricky part is to keep the current status while operating
class Solution {
    //single digits die on the next round
    public void gameOfLife(int[][] board) {
        if(board.length==0 || board[0].length ==0)
            return;
        int m=board.length,n=board[0].length;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int curr=board[i][j],living=helper(board,i,j);
                if(curr==0 &&living==3){
                    board[i][j]=10;
                }
                else if(curr==1){
                    if(living==2 || living == 3)
                        board[i][j]=11;
                }
            }
        }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j]=(board[i][j]>9)?1:0;
        
    }
    public int helper (int[][]board,int i,int j){
        int m=board.length,n=board[0].length,living=0;
        
        for(int a=Math.max(i-1,0);a<=Math.min(i+1,m-1);a++){
            
            for(int b=Math.max(j-1,0);b<=Math.min(j+1,n-1);b++){
                if(a==i && b==j)
                    continue;
                else if(board[a][b]%5==1) //10%5=0
                    living++;
            }
            
        }
        
        return living;
    }
}
