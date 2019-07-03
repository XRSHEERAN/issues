public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ret=new int[length];
        
        for(int[] u : updates){
            ret[u[0]]+=u[2];
            if(u[1]<length-1){
                ret[u[1]+1]-=u[2];
            }
        }
        int num=0;
        for(int i=0;i<ret.length-1;++i){
            num+=ret[i];
            ret[i]=num;
        }
        ret[length-1]=num+ret[length-1];
        return ret;
    }
}
