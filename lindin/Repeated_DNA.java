//uses hashtable to gothrough the whole list, can be slow
import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10)
            return new ArrayList<String>();
        Hashtable<String,Integer> tbl=new Hashtable<String,Integer>();
        int strt=0;
        while(strt+9<s.length()){
            String temp=s.substring(strt,strt+10);
            if(!tbl.containsKey(temp))
                tbl.put(temp,0);
            else
                tbl.put(temp,1);
            strt++;
        }
        Set<String> kSet=tbl.keySet();
        List<String> ret=new ArrayList<String> ();
        for(String k : kSet){
            if(tbl.get(k)==1)
                ret.add(k);
        }
        return ret;
    }
}
