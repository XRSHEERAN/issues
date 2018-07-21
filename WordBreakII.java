class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0 || s.length()==0)
            return new ArrayList<String>();
        Map<String,List<String>> mem=new HashMap<String,List<String>>();
        return helper(s,wordDict,mem);
        
    }
    private List<String> helper(String s, List<String> checker, Map<String,List<String>> mem){
        if(mem.containsKey(s))
            return mem.get(s);
        if(s.length()==0)
            return null;
        List<String> curr=new ArrayList<String>();
        for(String i : checker){
            if(s.startsWith(i)){
                if(i.length()==s.length()){
                    curr.add(s);
                    continue;
                }
                
                List<String> temp=helper(s.substring(i.length()),checker,mem);
                
                for(String t:temp){
                    curr.add(i+" "+t);
                }
            }
        }
        
        mem.put(s,curr);
        
        return curr;
    }
}
