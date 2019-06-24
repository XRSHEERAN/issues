public class Solution {
    /**
     * @param grid: the grid
     * @return: the number of corner rectangles
     */
    public int countCornerRectangles(int[][] grid) {
        // Write your code here
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int r=grid.length, c=grid[0].length,ret=0;
        //move two lines and count the vertical point pairs
        for(int i=0;i<r-1;++i){
            for(int j=i+1;j<r;++j){
                int count=0;
                for(int h=0;h<grid[0].length;++h){
                    if(grid[i][h]==1 && grid[j][h]==1){
                        ++count;
                    }
                }
                if(count<2){
                    continue;
                }
                //kept all pairs of 1-1, combination can be: (first+Last)*(count-1)/2, arithmetic series
                ret+=((count-1)*count/2);
                System.out.println(ret);
            }
        }
        return ret;
    }
}
