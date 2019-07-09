public class Solution {
    /**
     * @param S: a string
     * @param words: a dictionary of words
     * @return: the number of words[i] that is a subsequence of S
     */
     private class ptrS{
         public int p;
         public String s;
         public ptrS(String w){
             s=w;
             p=0;
         }
     }
    public int numMatchingSubseq(String S, String[] words) {
        // Write your code here
        List<ptrS> tbl=new LinkedList<>();
        HashMap<String,Integer> hst=new HashMap<>();
        for(String s : words){
            if(!hst.containsKey(s)){
                hst.put(s,1);
                tbl.add(new ptrS(s));
            }
            else
                hst.put(s,hst.get(s)+1);
        }
        int ret=0;
        for(int i=0;i<S.length();++i){
            char curr=S.charAt(i);
            if(tbl.size()==0){
                break;
            }
            for (Iterator<ptrS> itr = tbl.iterator(); itr.hasNext();) {
                ptrS c=itr.next();
                if(c.s.charAt(c.p)==curr){
                    c.p=c.p+1;
                }
                if(c.p==c.s.length()){
                    ret+=hst.get(c.s);
                    itr.remove();
                }
            }
        }
        return ret;
    }
}
