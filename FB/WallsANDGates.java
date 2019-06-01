public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        if(rooms.length==0 || rooms[0].length==0){
            return;
        }
        Queue<int[]> line=new LinkedList<int[]>();
        boolean[][] vst=new boolean[rooms.length][rooms[0].length];
        for(int i=0;i<rooms.length;++i){
            for(int j=0;j<rooms[0].length;++j){
                if(rooms[i][j]==0){
                    vst[i][j]=true;
                    line.add(new int[]{i,j,0});
                }
            }
        }
        int[][] dir=new int[][]{new int[]{0,-1},new int[]{0,1},new int[]{1,0},new int[]{-1,0}};
        while(!line.isEmpty()){
            int[] temp=line.poll();
            if(vst[temp[0]][temp[1]] && rooms[temp[0]][temp[1]]!=0){
                    continue;
            }
            vst[temp[0]][temp[1]]=true;
            if(rooms[temp[0]][temp[1]]!=0){
                rooms[temp[0]][temp[1]]=temp[2];
            }
            for(int[] a:dir){
                
                int r=temp[0]+a[0],c=temp[1]+a[1];
                
                if(r>=0 && r<rooms.length && c>=0 && c<rooms[0].length && !vst[r][c] && rooms[r][c]!=-1){
                    line.add(new int[]{r,c,temp[2]+1});
                }
            }
        }
        
        
    }
}
