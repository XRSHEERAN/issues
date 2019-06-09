public class Solution {
    /**
     * @param matrix: List[List[int]]
     * @param k: a integer
     * @return: return a integer
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<int[]> line=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
            
        });
        for(int i=0;i<matrix.length;++i){
            line.add(new int[]{0,i,matrix[0][i]});
        }
        int[] ret=new int[2];
        for(int i=0;i<k;++i){
            ret=line.poll();
            if(ret[0]==matrix.length-1){
                continue;
            }
            line.add(new int[]{ret[0]+1,ret[1],matrix[ret[0]+1][ret[1]]});
        }
        return matrix[ret[0]][ret[1]];
    }
}
