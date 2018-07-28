class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid.length==0)
            return 0;
        
        boolean[][] tracker=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(!tracker[i][j] && grid[i][j]=='1'){
                    count++;
                    marked(i,j,tracker,grid);
                }
            }
        }
        return count;
    }
    private void marked(int i, int j, boolean[][] tracker,char[][] grid){
        if(i<0 || i>=tracker.length || j<0 || j>=tracker[0].length || tracker[i][j] || grid[i][j]=='0')
            return;
        if(grid[i][j]=='1'){
            tracker[i][j]=true;
        }
        marked(i+1,j,tracker,grid);        
        marked(i-1,j,tracker,grid);
        marked(i,j+1,tracker,grid);
        marked(i,j-1,tracker,grid);

    }
}
