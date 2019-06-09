public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: return an integer
     */
    public int longestSubstring(String s, int k) {
        // write your code here
        
        HashMap<Character,Integer> count=new HashMap<>();
        for(int i=0;i<s.length();++i){
            char c=s.charAt(i);
            count.put(c,count.getOrDefault(c,0)+1);
        }
        
        LinkedList<String> lst=new LinkedList<>();
        int pre=0;
        boolean full=true;
        for(int i=0;i<s.length();++i){
            if(count.get(s.charAt(i))<k){
                if(i-pre>=k){
                    lst.add(s.substring(pre,i));
                }
                full=false;
                pre=i+1;
            }
            
        }
        if(s.length()-pre>=k){
            lst.add(s.substring(pre,s.length()));
        }
        if(full){
            return s.length();
        }
        int curr=0;
        for(String str:lst){
            if(curr>=str.length()){
                continue;
            }
            curr=Math.max(longestSubstring(str,k),curr);
        }
        return curr;
    }
}
