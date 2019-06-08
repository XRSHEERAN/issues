public class Solution {
    /**
     * @param s: a string represent DNA sequences
     * @return: all the 10-letter-long sequences 
     */
    public List<String> findRepeatedDna(String s) {
        // write your code here
        HashSet<String> hst=new HashSet<>(),vst=new HashSet<>();
        List<String> ret=new LinkedList<String>();
        for(int i=0;i<s.length()-9;++i){
            String str=s.substring(i,i+10);
            if(!hst.add(str) && vst.add(str)){
                ret.add(str);
            }
        }
        return ret;
    }
}
