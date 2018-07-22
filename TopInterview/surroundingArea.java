class Solution {
    public void solve(char[][] board) {
        
        if(board.length==0 || board[0].length==0)
            return;
        
        int row =board.length,col=board[0].length;
        
        boolean[][] map=new boolean[row][col];
        
        for(int i=0;i<row;i++){
           checkAround(map,board,i,0);
           checkAround(map,board,i,col-1);
        }
        
        for(int i=1;i<col-1;i++){
            checkAround(map,board,0,i);
            checkAround(map,board,row-1,i);
        }
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(!map[i][j])
                    board[i][j]='X';
    }
    private void checkAround(boolean[][] map, char[][] board, int i, int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || map[i][j]==true)
            return; //visited or out of boarder
        map[i][j]=(board[i][j]=='O');
        if(map[i][j]){
            checkAround(map,board,i-1,j);
            checkAround(map,board,i+1,j);
            checkAround(map,board,i,j+1);
            checkAround(map,board,i,j-1);
        }
    }
}
