//The edit distance 1
public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        if(s.equals(t)){
            return false;
        }
        
        String l=(s.length()>=t.length())?s:t, sh=(s.length()>=t.length())?t:s;
        
        if(l.length()>(sh.length()+1) ){
            return false;
        }
        for(int i=0;i<sh.length()-1;++i){
            if(l.charAt(i)!=s.charAt(i)){
                if(l.length()==sh.length()){
                    return l.substring(i+1).equals(s.substring(i+1));
                }
                else{
                    return l.substring(i+1).equals(s.substring(i));
                }
            }
        }
        return true;
    }
}
