class Solution {
    private int max;
    public int longestSubstring(String s, int k) {
        if(s.length()<k)
            return 0;
        if(k==0)
            return s.length();
        max=0;
    }
    private void traversal(Map<Character,Integer> tbl, String s, int strt, int end, int k){
        if(end-strt<k){
            if(k==1)
                max=Math.max(max,1);
            return;
        }
        char strtC=s.charAt(strt), endC=s.charAt(end);
        int strtN=tbl.get(strtC), endN=tbl.get(endC);
        
        if(strtN<k && endN<k){
            traversal(tbl,s,strt+1,end-1);
        }
        else if(strtN<k)
            traversal(tbl,s,strt+1,end);
        else if(endN<k)
            traversal(tbl,s,strt,end-1);
        else{
            tbl.put(endC, endN-1);
            traversal(tbl,s,strt,end-1);
            tbl.put(endC,endN);
            tbl.put(strtC,strtN-1);
            traversal(tbl,s,strt+1,end);
            tbl.put(strtC,strtN);
        }
    }
}
