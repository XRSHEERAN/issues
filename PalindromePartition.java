class Solution {
    public List<List<String>> partition(String s) {
        List<String> curr=new ArrayList<String> ();
        List<List<String>> ret=new ArrayList<List<String>>();
        
        if(s.length()==0){
            curr.add("");
            ret.add(curr);
            return ret;
        }
        
        helper(ret,s,curr);
        return ret;
    }
    private void helper(List<List<String>> ret, String s, List<String> curr){
        
        if(s.length()==0){
            ret.add(new ArrayList<String>(curr));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPal(s,0,i)){
                
                curr.add(s.substring(0,i+1));
                helper(ret,s.substring(i+1),curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPal(String curr, int strt, int end){
        while(strt<end)
            if(curr.charAt(strt++)!=curr.charAt(end--))
                return false;
        return true;
    }
}
