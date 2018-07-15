class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()==0)
            return 0;
        StringBuilder sb=new StringBuilder();
        int lst=0;
        for(char i : s.toCharArray()){
            if(i==' '){
                lst=(sb.length()==0)?lst:sb.length();
                sb=new StringBuilder();
            }
            else
                sb.append(i);
        }
        return (sb.length()==0)?lst : sb.length();
    }
}
