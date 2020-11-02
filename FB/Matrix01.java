class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][]  ret = new int[matrix.length][matrix[0].length];
        Queue<Integer> q = new LinkedList<>();
        int C = matrix[0].length;
        for(int i = 0;i<matrix.length;++i){
            for(int j =0;j<matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    q.add(i*C + j);
                    ret[i][j] = 0;
                }else{
                    ret[i][j] = 201;
                }
            }
        }
        int[][] dirs = new int[][]{new int[]{-1,0},new int[]{1,0},new int[]{0,-1},new int[]{0,1}};
        while(!q.isEmpty()){
            int code = q.remove();
            System.out.println(code);
            int r = code/C, c = code%C;
            for(int[] d : dirs){
                int tempR = r+d[0], tempC = c+d[1];
                if(tempR<0 || tempR>=matrix.length || tempC < 0 || tempC >= matrix[0].length){
                    continue;
                }
                if(matrix[tempR][tempC] == 1){
                    matrix[tempR][tempC] = 3;
                    ret[tempR][tempC] = ret[r][c]+1;
                    q.add(tempR*C + tempC);
                }
            }
        }
        return ret;
    }
}
