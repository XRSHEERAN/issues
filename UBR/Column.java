public class Solution {
    /**
     * @param s: a string
     * @return: return a integer
     */
    public int titleToNumber(String s) {
        // write your code here
        int base=1,ret=0;
        for(int i=s.length()-1;i>=0;--i){
            ret+=((s.charAt(i)-'A'+1)*base);
            base*=26;
        }
        return ret;
    }
}
