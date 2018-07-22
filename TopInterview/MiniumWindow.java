class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length()<t.length())
            return "";
        Map<Character,Integer> mp=new HashMap<Character,Integer>();
        for(char c : t.toCharArray()) mp.put(c,(mp.containsKey(c))?mp.get(c)+1:1);
        String minLen="";
        
        
        int count=0,rgt=s.length()-1;
        for(int lft=s.length()-1;lft>=0;lft--){
            char curr=s.charAt(lft);
            
            if(mp.containsKey(curr)){
                mp.put(curr,mp.get(curr)-1);
                count=(mp.get(curr)>=0)?count+1:count;
            }
            
            while(count==t.length()){
                curr=s.charAt(rgt);
                rgt--;
                
                if(mp.containsKey(curr)){
                    mp.put(curr,mp.get(curr)+1);
                    if(mp.get(curr)>0){
                        count--;
                    }
                }
                minLen=((minLen.length()<rgt-lft+2) && minLen.length()>0)?minLen:s.substring(lft,rgt+2);
            }
            
        }
        
        return minLen;
    }
}
