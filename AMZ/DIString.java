public class Solution {
    public int[] diStringMatch(String S) {
        int[] ret=new int[S.length()+1];
        int inc=0;
        for(int i=0;i<S.length();++i){
            if(S.charAt(i)=='I'){
                ret[i]=inc;
                ++inc;
            }
        }
        ret[S.length()]=inc;
        ++inc;
        for(int i=S.length()-1;i>=0;--i){
            if(S.charAt(i)=='D'){
                ret[i]=inc;
                ++inc;
            }
        }
        return ret;
    }
}
