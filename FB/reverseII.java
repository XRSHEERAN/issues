public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        char[] ret=new char[str.length];
        int lft=str.length-1,rgt=str.length-1,ptr=0;
        while(lft>-1){
            while(lft>-1 && str[lft]!=' '){
                --lft;
            }
            if(ptr>0){
                ret[ptr++]=' ';
            }
            int temp=lft-1;
            while(rgt>lft){
                ret[ptr++]=str[++lft];
            }
            lft=temp;
            rgt=lft;
        }
        return ret;
    }
}
