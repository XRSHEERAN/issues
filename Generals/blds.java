public class Solution {
    /**
     * @param grid: the 2D grid
     * @return: the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        if(grid.length==0 || grid[0].length==0){
            return -1;
        }
        ArrayList<int[]> bldL=new ArrayList<int[]>(grid.length*grid[0].length);
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(grid[i][j]==1){
                    bldL.add(new int[]{i,j});
                }
            }
        }
        
        int[][] dist=new int[grid.length][grid[0].length];
        int[][] count=new int[grid.length][grid[0].length];
        
        for(int i=0;i<bldL.size();++i){
            
            int[] temp;//curr coordinates
            Queue<int[]> Reached=new LinkedList<int[]>();//current reached blds
            Reached.add(bldL.get(i));
            int[][] vst= new int[grid.length][grid[0].length];//visited empty spaces
            int lvl=1;//current level
            vst[bldL.get(i)[0]][bldL.get(i)[1]]=1;
            
            while(!Reached.isEmpty()){
                
                
                Queue<int[]> tempQ=new LinkedList<int[]>();//store next level
                
                while(!Reached.isEmpty()){
                    temp=Reached.poll();
                    
                    int x=temp[0],y=temp[1];
                    
                    if(x-1>=0 && grid[x-1][y]==0 && vst[x-1][y]==0){
                        vst[x-1][y]=1;
                        tempQ.add(new int[]{x-1,y});
                        dist[x-1][y]+=lvl;
                        ++count[x-1][y];
                        
                    }
                    if(x+1<grid.length && grid[x+1][y]==0 && vst[x+1][y]==0){
                        vst[x+1][y]=1;
                        tempQ.add(new int[]{x+1,y});
                        dist[x+1][y]+=lvl;
                        ++count[x+1][y];
                        
                    }
                    if(y-1>=0 && grid[x][y-1]==0 && vst[x][y-1]==0){
                        vst[x][y-1]=1;
                        tempQ.add(new int[]{x,y-1});
                        dist[x][y-1]+=lvl;
                        ++count[x][y-1];
                        
                    }
                    if(y+1<grid[0].length && grid[x][y+1]==0 && vst[x][y+1]==0){
                        vst[x][y+1]=1;
                        tempQ.add(new int[]{x,y+1});
                        dist[x][y+1]+=lvl;
                        ++count[x][y+1];
                        
                    }
                }
                ++lvl;
                Reached=tempQ;
            }
            
        }
        int ret=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                
                if(count[i][j]==bldL.size()){
                    
                    ret=Math.min(ret,dist[i][j]);
                }
            }
        }
        return ret;
    }
}
