public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        HashMap<Character,Integer> tbl=new HashMap<Character,Integer>(26);
        int lft=0,diff=0,ret=0;
        for(int i=0;i<s.length();++i){
            char temp=s.charAt(i);
            if(!tbl.containsKey(temp)){
                tbl.put(temp,1);
                ++diff;
            }
            else{
                tbl.put(temp,tbl.get(temp)+1);
            }
            while(diff>k){
                char rm=s.charAt(lft++);
                int num=tbl.get(rm);
                if(num==1){
                    tbl.remove(rm);
                    --diff;
                }
                else{
                    tbl.put(rm,num-1);
                }
            }
            ret=Math.max(ret,i-lft+1);
        }
        return ret;
    }
}
