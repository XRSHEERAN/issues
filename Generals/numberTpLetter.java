class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret=new ArrayList<String>();
        if(digits.length()==0)
            return ret;
        insert(digits,0,ret,"");
        return ret;
    }
    private void insert(String digits, int ptr, List<String> ret, String curr){
        if (ptr==digits.length()){
            ret.add(curr);
            return;
        }
        int temp=digits.charAt(ptr)-'0', stp=(temp==9||temp==7)?4:3;
        for(int i=(temp-2)*3;i<(temp-2)*3+stp;i++){
            char addin=(temp==8||temp==9)?'b':'a';
            addin+=i;
            insert(digits,ptr+1,ret,new String(curr+addin));
        }
    }
}
