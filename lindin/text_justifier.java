
class Solution {
    private int strt;
    public List<String> fullJustify(String[] words, int maxWidth) {
        strt=0;
        List ret=new ArrayList();
        while(strt<words.length){
            ret.add(helper(words,maxWidth));
        }
        return ret;
    }
    public String helper(String[] words, int len){
        StringBuilder str=new StringBuilder();
        int base=words[strt].length();
        int pt=strt;
        List<Integer> spclst=new ArrayList();
        while(strt+1<words.length && base<len){
            if(base+1+words[strt+1].length()<=len)
                base+=(1+words[++strt].length());
            else
                break;
        }
        
        if(pt==strt){
            str.append(words[strt]+mulspace(len-words[strt].length()));
            strt++;
            return str.toString();
        }
        if(strt == (words.length-1)){
            while(pt<strt){
                str.append(words[pt]+" ");
                pt++;
            }
            str.append(words[strt]+mulspace(len-base));
            strt++;
            return str.toString();
        }
        int numspc=(len-base)/(strt-pt)+1; //number of spc to append
        System.out.println(base);
        int left=len-((numspc-1)*(strt-pt)+base);
        while(pt<strt){
            int num=numspc;
            if(left-->0)
                num++;
            str.append(words[pt]+mulspace(num));
            pt++;
        }
        str.append(words[strt]);
        strt++;
        return str.toString();
    }
    public String mulspace(int num){
        StringBuilder str= new StringBuilder();
        while(num>0){
            str.append(" ");
            num--;
        }
        return str.toString();
    }
}
