public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        // write your code here
        int ret=strs[0].length();
        for(int i=0;i<strs.length-1;++i){
            int curr=common(strs[i+1],strs[i]);
            ret=Math.min(curr,ret);
        }
        return strs[0].substring(0,ret);
    }
    private int common(String a, String b){
        int p=0;
        while(p<a.length() && p<b.length()){
            if(a.charAt(p)!=b.charAt(p)){
                break;
            }
            ++p;
        }
        return p;
    }
}
