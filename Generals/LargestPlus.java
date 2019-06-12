public class Solution {
    /**
     * @param N: size of 2D grid
     * @param table: in the given list
     * @return: the order of the plus sign
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // Write your code here
        int[][] counter=new int[N][N], table=new int[N][N];
        
        for(int[] m : mines){
            table[m[0]][m[1]]=1;
        }
        int ret=0;
        for(int i=0;i<table.length;++i){
            int temp=0;
            for(int j=0;j<table.length;++j){
                counter[i][j]=temp;
                if(table[i][j]==0){
                    ++temp;
                }
                else{
                    temp=0;
                }
            }
            temp=0;
            for(int j=table.length-1;j>=0;--j){
                counter[i][j]=Math.min(temp,counter[i][j]);
                if(table[i][j]==0){
                    ++temp;
                }
                else{
                    temp=0;
                }
            }
        }
        for(int i=0;i<table.length;++i){
            int temp=0;
            for(int j=0;j<table.length;++j){
                counter[j][i]=Math.min(temp,counter[j][i]);
                if(table[j][i]==0){
                    ++temp;
                }
                else{
                    temp=0;
                }
            }
            temp=0;
            for(int j=table.length-1;j>=0;--j){
                counter[j][i]=Math.min(temp,counter[j][i]);
                if(table[j][i]==0){
                    ret=Math.max(ret,counter[j][i]+1);
                }
                if(table[j][i]==0){
                    ++temp;
                }
                else{
                    temp=0;
                }
            }
        }
        return ret;
        
    }
}
